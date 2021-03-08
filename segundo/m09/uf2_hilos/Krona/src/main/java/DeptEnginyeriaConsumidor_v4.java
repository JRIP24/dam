public class DeptEnginyeriaConsumidor_v4 implements Runnable{

    private MagatzemCombustible_v4 magatzemDeCombustible;


    public DeptEnginyeriaConsumidor_v4(MagatzemCombustible_v4 borsaDeLLetres) {
        this.magatzemDeCombustible = borsaDeLLetres;
    }


    @Override
    public void run() {
        int i = 0;
        boolean exitOperacio;

        System.out.println("2222 - DeptEnginyeriaConsumidor.INICI");

        i = 0;
        while ( i < 13) {
            exitOperacio = magatzemDeCombustible.consumirContenidorDeCombustible();

            if (exitOperacio) {
                i++;
            }
        }

        System.out.println("2222 - DeptEnginyeriaConsumidor.FI");
    }
}
