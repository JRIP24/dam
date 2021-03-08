public class DeptEnginyeriaConsumidor_v5 implements Runnable{

    private MagatzemCombustible_v5 magatzemDeCombustible = new MagatzemCombustible_v5();
    private int numContenidorsPerAgafar;

    public DeptEnginyeriaConsumidor_v5(MagatzemCombustible_v5 borsaDeLLetres, int num) {
        this.magatzemDeCombustible = borsaDeLLetres;
        this.numContenidorsPerAgafar = num;
    }


    @Override
    public void run() {
        int i = 0;
        boolean exitOperacio;

        System.out.println("2222 - " + Thread.currentThread().getName() + ".INICI");

        i = 0;
        while ( i < numContenidorsPerAgafar) {
            exitOperacio = magatzemDeCombustible.consumirContenidorDeCombustible();

            if (exitOperacio == true) {
                i++;
            }
        }

        System.out.println("2222 - " + Thread.currentThread().getName() + ".FI");
    }
}
