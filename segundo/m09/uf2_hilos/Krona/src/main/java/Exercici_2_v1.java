public class Exercici_2_v1 {

    public static void inicialitzarPrograma(){
        MagatzemCombustible_v1 magatzemCombustible_v1 = new MagatzemCombustible_v1();
        DeptCienciaProductor_v1 deptCienciaProductor_v1 = new DeptCienciaProductor_v1(magatzemCombustible_v1);
        DeptEnginyeriaConsumidor_v1 deptEnginyeriaConsumidor_v1 = new DeptEnginyeriaConsumidor_v1(magatzemCombustible_v1);

        deptCienciaProductor_v1.start();
        deptEnginyeriaConsumidor_v1.start();

        //Para que el hilo principal no acabe hasta que se acaben los hilos anteriores
        try{
            deptCienciaProductor_v1.join();
            deptEnginyeriaConsumidor_v1.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Exercici_2.magatzemDeCombustible.posicionsEnMagatzem = " + new String(magatzemCombustible_v1.posicionsEnMagatzem));
        System.out.println("Exercici_2.inicialitzarPrograma() - FI");
    }
}
