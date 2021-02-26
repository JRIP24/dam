public class Exercici_2_v5 {

    public static void inicialitzarPrograma(){
        MagatzemCombustible_v5 magatzemCombustible_v5 = new MagatzemCombustible_v5();
        DeptCienciaProductor_v5 deptCienciaProductor_v5 = new DeptCienciaProductor_v5(magatzemCombustible_v5);
        DeptEnginyeriaConsumidor_v5 deptEnginyeriaConsumidor_v5 = new DeptEnginyeriaConsumidor_v5(magatzemCombustible_v5, 7);
        DeptEnginyeriaConsumidor_v5 deptEnginyeriaConsumidor_2_v5 = new DeptEnginyeriaConsumidor_v5(magatzemCombustible_v5, 10);

        System.out.println("Exercici_6.inicialitzarPrograma() - INICI");
        System.out.println("Exercici_6.magatzemDeCombustible.posicionsEnMagatzem = " + magatzemCombustible_v5.posicionsEnMagatzem);

        Thread deptCienciaProductor = new Thread(deptCienciaProductor_v5);
        Thread deptEnginyeriaConsumidor1 = new Thread(deptEnginyeriaConsumidor_v5);
        Thread deptEnginyeriaConsumidor2 = new Thread(deptEnginyeriaConsumidor_2_v5);

        deptEnginyeriaConsumidor1.setName("deptEnginyeriaConsumidor_1");
        deptEnginyeriaConsumidor2.setName("deptEnginyeriaConsumidor_2");

        deptCienciaProductor.start();
        deptEnginyeriaConsumidor1.start();
        deptEnginyeriaConsumidor2.start();

        try {
            deptCienciaProductor.join();
            deptEnginyeriaConsumidor1.join();
            deptEnginyeriaConsumidor2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Exercici_6.magatzemDeCombustible.posicionsEnMagatzem = " + magatzemCombustible_v5.posicionsEnMagatzem);
        System.out.println("Exercici_6.inicialitzarPrograma() - FI");

    }
}
