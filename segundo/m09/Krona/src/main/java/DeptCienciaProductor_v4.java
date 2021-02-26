public class DeptCienciaProductor_v4 implements Runnable{

    private MagatzemCombustible_v4 magatzemDeCombustible;


    public DeptCienciaProductor_v4(MagatzemCombustible_v4 magatzemDeCombustible) {
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
