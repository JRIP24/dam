import java.util.ArrayList;
import java.util.Arrays;

public class MagatzemCombustible_v3 {

    ArrayList<Character> posicionsEnMagatzem = new ArrayList<Character>();

    public MagatzemCombustible_v3() {
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

    public synchronized void produirContenidorDeCombustible() {

        int posTmp;
        if(numContenidorsAlMagatzem() < 10){

            posTmp = posicionsEnMagatzem.indexOf('0');
            posicionsEnMagatzem.set(posTmp, '1');
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }


    public synchronized void consumirContenidorDeCombustible() {
        int posTmp;

        if (numContenidorsAlMagatzem() > 0){
            posTmp = posicionsEnMagatzem.indexOf('1');
            posicionsEnMagatzem.set(posTmp, '0');
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
