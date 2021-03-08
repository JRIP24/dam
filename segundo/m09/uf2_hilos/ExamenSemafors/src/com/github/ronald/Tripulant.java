package com.github.ronald;

import java.util.concurrent.Semaphore;

public class Tripulant implements Runnable{

    private int id;
    SPO10_Sirena3M sirena3M;
    Semaphore semaphoreCapsula;

    public Tripulant(int id, SPO10_Sirena3M sirena3M){
        this.id = id;
        this.sirena3M = sirena3M;
        this.semaphoreCapsula = new Semaphore(36);
    }


    @Override
    public void run() {

        boolean abandonarNave = false;

        while (abandonarNave == false){

            if(sirena3M.consultarAbandonamentNau()){

                try {
                    semaphoreCapsula.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                abandonarNave = true;
/*
                try {

                    Thread.currentThread().sleep((long)(Math.random() * 500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                sirena3M.demanarCapsulaSalvaVides(this.id);

                semaphoreCapsula.release();


            } else {
                try {
                    Thread.currentThread().sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }


    }




}
