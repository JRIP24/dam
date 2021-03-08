public class DeptCienciaProductor_v1 extends Thread{

    private MagatzemCombustible_v1 magatzemDeCombustible;


    public DeptCienciaProductor_v1(MagatzemCombustible_v1 magatzemDeCombustible) {
        this.magatzemDeCombustible = magatzemDeCombustible;
    }

    @Override
    public void run() {
        int i;

        System.out.println("1111 - DeptCienciaProductor.INICI");

        i = 0;
        while (i < 20) {
            if (magatzemDeCombustible.numContenidorsAlMagatzem() < 10) {
                System.out.println("1111.1 - DeptCienciaProductor.run(), numContenidorsAlMagatzem() = " + magatzemDeCombustible.numContenidorsAlMagatzem() +  ", " + new String(magatzemDeCombustible.posicionsEnMagatzem));
                magatzemDeCombustible.produirContenidorDeCombustible();
                System.out.println("1111.2 - DeptCienciaProductor.run(), numContenidorsAlMagatzem() = " + magatzemDeCombustible.numContenidorsAlMagatzem() +  ", " + new String(magatzemDeCombustible.posicionsEnMagatzem));

                i++;
            }
        }

        System.out.println("1111 - DeptCienciaProductor.FI");
    }
}
