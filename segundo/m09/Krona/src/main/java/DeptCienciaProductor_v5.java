public class DeptCienciaProductor_v5 implements Runnable{

    private MagatzemCombustible_v5 magatzemDeCombustible;


    public DeptCienciaProductor_v5(MagatzemCombustible_v5 magatzemDeCombustible) {
        this.magatzemDeCombustible = magatzemDeCombustible;
    }


    @Override
    public void run() {
        int i;
        boolean exitOperacio;


        System.out.println("1111 - DeptCienciaProductor.INICI");

        i = 0;
        while (i < 20) {
            exitOperacio = magatzemDeCombustible.produirContenidorDeCombustible();

            if (exitOperacio == true) {
                i++;
            }
        }

        System.out.println("1111 - DeptCienciaProductor.FI");
    }
}
