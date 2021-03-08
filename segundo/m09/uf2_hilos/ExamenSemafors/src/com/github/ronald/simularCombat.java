package com.github.ronald;

public class simularCombat {

    public static void main(String[] args) {

        int numTripulants = 36;
        int maxTripulantsCapsula = 9;
        SPO10_Sirena3M sistema = new SPO10_Sirena3M(numTripulants);


        Thread sis = new Thread(sistema);
        sis.start();/*
        try {
            sis.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        //Creación de tripulantes
        for (int i = 1; i <= numTripulants; i++){

            Tripulant tripulantTmp = new Tripulant(i, sistema);
            Thread trip = new Thread(tripulantTmp);
            trip.setName("Tripulant " + i);
            trip.start();

            if (i == numTripulants){
                try {
                    //trip.join();
                    sis.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }







        //System.out.println(sistema.isDespistaremTorpede());
        //System.out.println("Abandonar nave: " + sistema.consultarAbandonamentNau());


        //System.out.println("Array"  + sistema.getUsDeLesCapsulesSalvaVides().get(0).size());
        System.out.println("MAIN: assignació de càpsules:");
        for (int x = 0; x < sistema.getUsDeLesCapsulesSalvaVides().size(); x++){
            String mensaje = "Càpsula " + x + " amb els tripulants [";
            for (int i = 0; i < sistema.getUsDeLesCapsulesSalvaVides().get(x).size(); i++){

                int idTripulant = sistema.getUsDeLesCapsulesSalvaVides().get(x).get(i);

                if ( sistema.getUsDeLesCapsulesSalvaVides().get(x).indexOf(idTripulant) == sistema.getUsDeLesCapsulesSalvaVides().get(x).size() - 1){
                    mensaje = mensaje + idTripulant ;
                } else {
                    mensaje = mensaje + idTripulant + ", ";
                }

            }
            mensaje = mensaje + "]";
            System.out.println(mensaje);
        }
    }
}
