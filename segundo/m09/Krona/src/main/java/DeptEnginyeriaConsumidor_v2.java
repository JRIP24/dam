public class DeptEnginyeriaConsumidor_v2 extends Thread{

    private MagatzemCombustible_v2 magatzemDeCombustible;


    public DeptEnginyeriaConsumidor_v2(MagatzemCombustible_v2 magatzemDeCombustible) {
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
                System.out.println("2222.1 - [" + i + "] - DeptEnginyeriaConsumidor.run(), numContenidorsAlMagatzem() = " + magatzemDeCombustible.numContenidorsAlMagatzem() + ", " + magatzemDeCombustible.posicionsEnMagatzem);
                magatzemDeCombustible.consumirContenidorDeCombustible();
                System.out.println("2222.2 - [" + i + "] - DeptEnginyeriaConsumidor.run(), numContenidorsAlMagatzem() = " + magatzemDeCombustible.numContenidorsAlMagatzem() +  ", " + magatzemDeCombustible.posicionsEnMagatzem);

                i++;
            }
        }

        System.out.println("2222 - DeptEnginyeriaConsumidor.FI");
    }
}