import java.util.ArrayList;
import java.util.Arrays;

public class MagatzemCombustible_v2 {

    ArrayList<Character> posicionsEnMagatzem = new ArrayList<Character>();

    public MagatzemCombustible_v2() {
        Character[] posicions = {'0','0','0','0','0','0','0','0','0','0'};
        posicionsEnMagatzem.addAll(Arrays.asList(posicions));
    }

    public synchronized int numContenidorsAlMagatzem() {
        int numContenidors;
        numContenidors = 0;
        for(char ocupada : posicionsEnMagatzem) {
            if (ocupada == '1') {
                numContenidors++;
            }
        }
        return numContenidors;
    }

    // EL PROBLEMA ES QUE 1 FIL POT ENTRAR EN produirContenidorDeCombustible() I UN ALTRE EN consumirContenidorDeCombustible() I
    // A LLAVORS ACCEDIR A LA VARIABLE posicionsEnMagatzem SIMULTÀNEAMENT I PROVOCAR UN ERROR A L'ESCRIURE EN ELLA.
    // PER AIXÒ DE VEGADES PETA.

    public void produirContenidorDeCombustible() {

        int posTmp;

        posTmp = posicionsEnMagatzem.indexOf('0');
        posicionsEnMagatzem.set(posTmp, '1');
    }


    public void consumirContenidorDeCombustible() {
        int posTmp;
        posTmp = posicionsEnMagatzem.indexOf('1');
        posicionsEnMagatzem.set(posTmp, '0');
    }

}
