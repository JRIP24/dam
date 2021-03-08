public class Exercici_2_v4 {

    public static void inicialitzarPrograma(){

        MagatzemCombustible_v4 magatzemCombustible_v4 = new MagatzemCombustible_v4();
        DeptCienciaProductor_v4 deptCienciaProductor_v4 = new DeptCienciaProductor_v4(magatzemCombustible_v4);
        DeptEnginyeriaConsumidor_v4 deptEnginyeriaConsumidor_v4 = new DeptEnginyeriaConsumidor_v4(magatzemCombustible_v4);

        System.out.println("Exercici_5.inicialitzarPrograma() - INICI");
        System.out.println("Exercici_5.magatzemDeCombustible.posicionsEnMagatzem = " + magatzemCombustible_v4.posicionsEnMagatzem);

        Thread depCienciaProductor = new Thread(deptCienciaProductor_v4);
        Thread depEnginyeriaConsumidor = new Thread(deptEnginyeriaConsumidor_v4);

        depCienciaProductor.start();
        depEnginyeriaConsumidor.start();

        try {
            depCienciaProductor.join();
            depEnginyeriaConsumidor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Exercici_5.magatzemDeCombustible.posicionsEnMagatzem = " + magatzemCombustible_v4.posicionsEnMagatzem);
        System.out.println("Exercici_5.inicialitzarPrograma() - FI");

    }


}
