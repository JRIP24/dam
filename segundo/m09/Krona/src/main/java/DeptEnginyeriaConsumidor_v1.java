public class DeptEnginyeriaConsumidor_v1 extends Thread{

    private MagatzemCombustible_v1 magatzemDeCombustible;


    public DeptEnginyeriaConsumidor_v1(MagatzemCombustible_v1 magatzemDeCombustible) {
        this.magatzemDeCombustible = magatzemDeCombustible;
    }


    @Override
    public void run() {
        char contenidor;
        int i = 0;

        System.out.println("2222 - DeptEnginyeriaConsumidor.INICI");

        i = 0;
        while ( i < 13) {
            if (magatzemDeCombustible.numContenidorsAlMagatzem() > 0) {
                System.out.println("2222.1 - [" + i + "] - DeptEnginyeriaConsumidor.run(), numContenidorsAlMagatzem() = " + magatzemDeCombustible.numContenidorsAlMagatzem() + ", " + new String(magatzemDeCombustible.posicionsEnMagatzem));
                magatzemDeCombustible.consumirContenidorDeCombustible();
                System.out.println("2222.2 - [" + i + "] - DeptEnginyeriaConsumidor.run(), numContenidorsAlMagatzem() = " + magatzemDeCombustible.numContenidorsAlMagatzem() +  ", " + new String(magatzemDeCombustible.posicionsEnMagatzem));

                i++;
            }
        }

        System.out.println("2222 - DeptEnginyeriaConsumidor.FI");
    }
}
