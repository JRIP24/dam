public class Exercici_2_v3 {

    public static void inicialitzarPrograma()  {
        MagatzemCombustible_v3 magatzemCombustible_v3 = new MagatzemCombustible_v3();
        DeptCienciaProductor_v3 deptCienciaProductor_v3 = new DeptCienciaProductor_v3(magatzemCombustible_v3);
        DeptEnginyeriaConsumidor_v3 deptEnginyeriaConsumidor_v3 = new DeptEnginyeriaConsumidor_v3(magatzemCombustible_v3);


        System.out.println("Exercici_4.inicialitzarPrograma() - INICI");
        System.out.println("Exercici_4.magatzemDeCombustible.posicionsEnMagatzem = " + magatzemCombustible_v3.posicionsEnMagatzem);

        //Como se ha usado la interfaz Runnable, ejecutaremos con clases Thread
        Thread deptCienciaProductor = new Thread(deptCienciaProductor_v3);
        Thread deptEnginyeriaConsumidor = new Thread(deptEnginyeriaConsumidor_v3);

        deptCienciaProductor.start();
        deptEnginyeriaConsumidor.start();

        try {
            deptCienciaProductor.join(5000);
            deptEnginyeriaConsumidor.join(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }


        System.out.println("Exercici_4.magatzemDeCombustible.posicionsEnMagatzem = " + magatzemCombustible_v3.posicionsEnMagatzem);
        System.out.println("Exercici_4.inicialitzarPrograma() - FI");
    }
}
