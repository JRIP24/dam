public class Exercici_2_v2 {

    public static void inicialitzarPrograma()  {
        MagatzemCombustible_v2 magatzemCombustible_v2 = new MagatzemCombustible_v2();
        DeptCienciaProductor_v2 deptCienciaProductor_v2 = new DeptCienciaProductor_v2(magatzemCombustible_v2);
        DeptEnginyeriaConsumidor_v2 deptEnginyeriaConsumidor_v2 = new DeptEnginyeriaConsumidor_v2(magatzemCombustible_v2);

        deptCienciaProductor_v2.start();
        deptEnginyeriaConsumidor_v2.start();

        try {
            deptCienciaProductor_v2.join();
            deptEnginyeriaConsumidor_v2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }


        System.out.println("Exercici_2.magatzemDeCombustible.posicionsEnMagatzem = " + magatzemCombustible_v2.posicionsEnMagatzem);
        System.out.println("Exercici_2.inicialitzarPrograma() - FI");
    }
}
