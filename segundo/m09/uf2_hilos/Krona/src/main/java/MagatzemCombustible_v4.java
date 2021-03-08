import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class MagatzemCombustible_v4 {

    ArrayList<Character> posicionsEnMagatzem = new ArrayList<Character>();
    private Semaphore semaforAccesALListaDePosicions;

    public MagatzemCombustible_v4(){
        Character[] posicions = {'0','0','0','0','0','0','0','0','0','0'};
        posicionsEnMagatzem.addAll(Arrays.asList(posicions));

        semaforAccesALListaDePosicions = new Semaphore(1); //Con 1, cualquiera que quiera ejecutar acquire() lo tendrá permitido

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

    public boolean produirContenidorDeCombustible() {

        int posTmp;
        boolean exitOperacio = false;

        if(numContenidorsAlMagatzem() < 10){

            try {
                semaforAccesALListaDePosicions.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("1111.1 - DeptCienciaProductor, numContenidorsAlMagatzem() = " + numContenidorsAlMagatzem() + ", " + posicionsEnMagatzem);

            posTmp = posicionsEnMagatzem.indexOf('0');
            posicionsEnMagatzem.set(posTmp, '1');

            exitOperacio = true;

        } else {
            exitOperacio = false;
        }

        System.out.println("1111.2 - DeptCienciaProductor, numContenidorsAlMagatzem() = " + numContenidorsAlMagatzem() + ", " + posicionsEnMagatzem + ", exitOperacio = " + exitOperacio);

        semaforAccesALListaDePosicions.release();

        return exitOperacio;

    }


    public boolean consumirContenidorDeCombustible() {
        int posTmp;
        boolean exitOperacio = false;

        if (numContenidorsAlMagatzem() > 0){

            try {
                semaforAccesALListaDePosicions.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("2222.1 - DeptEnginyeriaConsumidor, numContenidorsAlMagatzem() = " + numContenidorsAlMagatzem() + ", " + posicionsEnMagatzem);
            posTmp = posicionsEnMagatzem.indexOf('1');
            posicionsEnMagatzem.set(posTmp, '0');

            exitOperacio = true;
        } else {
            exitOperacio = false;
        }

        System.out.println("2222.2 - DeptEnginyeriaConsumidor, numContenidorsAlMagatzem() = " + numContenidorsAlMagatzem() + ", " + posicionsEnMagatzem + ", exitOperacio = " + exitOperacio);
        semaforAccesALListaDePosicions.release();

        return exitOperacio;

    }

}
