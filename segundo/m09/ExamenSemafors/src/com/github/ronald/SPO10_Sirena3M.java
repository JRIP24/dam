package com.github.ronald;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class SPO10_Sirena3M implements Runnable{
    private ArrayList<ArrayList<Integer>> usDeLesCapsulesSalvaVides;
    private boolean despistaremTorpede;
    private boolean abandonarLaNau;
    private SPS161_GheranF radar;
    Semaphore semaforCapsula; //Controla que solo 9 tripulantes accedan a una capsula
    Semaphore permisoAccesoCapsula;

    public SPO10_Sirena3M(int maxTripulants) {
        this.usDeLesCapsulesSalvaVides = new ArrayList<>();

        this.usDeLesCapsulesSalvaVides.add(new ArrayList<Integer>());
        this.usDeLesCapsulesSalvaVides.add(new ArrayList<Integer>());
        this.usDeLesCapsulesSalvaVides.add(new ArrayList<Integer>());
        this.usDeLesCapsulesSalvaVides.add(new ArrayList<Integer>());

        //this.usDeLesCapsulesSalvaVides.get(0).add(0);

        this.despistaremTorpede = true;
        this.abandonarLaNau = false;
        this.semaforCapsula = new Semaphore(9);
        this.permisoAccesoCapsula = new Semaphore(1);

    }


    @Override
    public void run() {

        System.out.println("SPO-10 Sirena-3M: INICI");
        System.out.println("SPO-10 Sirena-3M: detectat torpede enemic...");
        System.out.println("SPO-10 Sirena-3M: activant el interferidor de radar actiu SPS-161 Gheran-F");

        radar = new SPS161_GheranF(this);
        radar.start();
        try {
            radar.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (this.despistaremTorpede){
            System.out.println("SPS-161 Gherant-F ha desviat el torpede i no hi ha perill");
        }else {
            this.abandonarLaNau = true;

            /*
            try {
                Thread.currentThread().sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/



        boolean salir = false;
        while (salir == false){

            System.out.println("Size capsula 4:" + this.usDeLesCapsulesSalvaVides.get(3).size());

            if (this.usDeLesCapsulesSalvaVides.get(3).size() == 7){
                salir = true;
                System.out.println("SPO-10 Sirena-3M: llançament de les 4 càpsules...");
                System.out.println("SPO-10 Sirena-3M: FI");
            } else {
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

        }
    }

    public boolean consultarAbandonamentNau(){
        return this.abandonarLaNau;
    }

    public void demanarCapsulaSalvaVides(int numTripulant){

        try {

            semaforCapsula.acquire();
            //permisoAccesoCapsula.acquire();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("Tripulante " + numTripulant + " permisos disponibles: " + semaforCapsula.availablePermits());
        boolean added = false;
        for (int i = 0; i < this.usDeLesCapsulesSalvaVides.size(); i++){

            int numPosicio = i + 1;

            if (this.usDeLesCapsulesSalvaVides.get(i).size() <= semaforCapsula.availablePermits()){

                this.usDeLesCapsulesSalvaVides.get(i).add(numTripulant);
                added = true;

                System.out.println("Tripulant " + numTripulant + ", espai disponible en la càpsula " + numPosicio + " = " + this.usDeLesCapsulesSalvaVides.get(i).indexOf(numTripulant));
            }

            if (added){
                break;
            }

        }
        //permisoAccesoCapsula.release();
        semaforCapsula.release();
    }


    public ArrayList<ArrayList<Integer>> getUsDeLesCapsulesSalvaVides() {
        return usDeLesCapsulesSalvaVides;
    }

    public void setUsDeLesCapsulesSalvaVides(ArrayList<ArrayList<Integer>> usDeLesCapsulesSalvaVides) {
        this.usDeLesCapsulesSalvaVides = usDeLesCapsulesSalvaVides;
    }

    public boolean isDespistaremTorpede() {
        return despistaremTorpede;
    }

    public void setDespistaremTorpede(boolean despistaremTorpede) {
        this.despistaremTorpede = despistaremTorpede;
    }

    public boolean isAbandonarLaNau() {
        return abandonarLaNau;
    }

    public void setAbandonarLaNau(boolean abandonarLaNau) {
        this.abandonarLaNau = abandonarLaNau;
    }
}
