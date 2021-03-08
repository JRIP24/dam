import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class MagatzemCombustible_v5 {

    ArrayList <Character> posicionsEnMagatzem = new ArrayList<Character>();
    private Semaphore semaforAccesALListaDePosicions;

    public MagatzemCombustible_v5() {
        Character[] posicions = {'0','0','0','0','0','0','0','0','0','0'};
        posicionsEnMagatzem.addAll(Arrays.asList(posicions));

        semaforAccesALListaDePosicions = new Semaphore(1);
    }



    public int numContenidorsAlMagatzem() {
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


        try {
            semaforAccesALListaDePosicions.acquire();
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        System.out.println("1111.1 - DeptCienciaProductor, numContenidorsAlMagatzem() = " + numContenidorsAlMagatzem() + ", " + posicionsEnMagatzem);

        if (numContenidorsAlMagatzem() < 10) {
            posTmp = posicionsEnMagatzem.indexOf('0');

            posicionsEnMagatzem.set(posTmp, '1');
            // El mètode add(pos, '1') fa un INSERT un '1' en la posició 'pos' i mou la resta d'elements que hi ha
            // des de 'pos' cap a la dreta 1 posició per a deixar un forat pel nou '1'. El mètode set fa un UPDATE.

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


        try {
            semaforAccesALListaDePosicions.acquire();
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        System.out.println("2222.1 - " + Thread.currentThread().getName() + ", numContenidorsAlMagatzem() = " + numContenidorsAlMagatzem() + ", " + posicionsEnMagatzem);

        if (numContenidorsAlMagatzem() > 0) {
            posTmp = posicionsEnMagatzem.indexOf('1');

            posicionsEnMagatzem.set(posTmp, '0');

            exitOperacio = true;
        } else {
            exitOperacio = false;
        }

        System.out.println("2222.2 - " + Thread.currentThread().getName() + ", numContenidorsAlMagatzem() = " + numContenidorsAlMagatzem() + ", " + posicionsEnMagatzem + ", exitOperacio = " + exitOperacio);

        semaforAccesALListaDePosicions.release();

        return exitOperacio;
    }

}
