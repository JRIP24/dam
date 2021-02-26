public class DeptCienciaProductor_v3 implements Runnable{

    private MagatzemCombustible_v3 magatzemDeCombustible;


    public DeptCienciaProductor_v3(MagatzemCombustible_v3 magatzemDeCombustible) {
        this.magatzemDeCombustible = magatzemDeCombustible;
    }

    @Override
    public void run() {
        int i;

        System.out.println("1111 - DeptCienciaProductor.INICI");

        i = 0;
        while (i < 20) {
            if (magatzemDeCombustible.numContenidorsAlMagatzem() < 10) {
                System.out.println("1111.1 - DeptCienciaProductor.run(), numContenidorsAlMagatzem() = " + magatzemDeCombustible.numContenidorsAlMagatzem() +  ", " + magatzemDeCombustible.posicionsEnMagatzem);
                magatzemDeCombustible.produirContenidorDeCombustible();
                System.out.println("1111.2 - DeptCienciaProductor.run(), numContenidorsAlMagatzem() = " + magatzemDeCombustible.numContenidorsAlMagatzem() +  ", " + magatzemDeCombustible.posicionsEnMagatzem);

                i++;
            }
        }

        System.out.println("1111 - DeptCienciaProductor.FI");
    }
}
