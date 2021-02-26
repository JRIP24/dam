package com.github.ronald;

public class SPS161_GheranF extends Thread{

    SPO10_Sirena3M sistema;

    public SPS161_GheranF(SPO10_Sirena3M sistema){
        this.sistema = sistema;
    }

    @Override
    public void run() {

        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("SPS-161 Gheran-F: no puc despistar al torpede enemic");
        sistema.setDespistaremTorpede(false);
        System.out.println("SPS-161 Gheran-F: FI");

    }
}
