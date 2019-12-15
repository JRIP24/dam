import java.util.Scanner;

import javax.swing.plaf.synth.SynthTextAreaUI;

public class Program{

    public static void writeArithmeticProgression(float t1, float d, float n){

        float next;
        float actual = t1;

        System.out.println(actual);

        for(float i = 1; i < n; i++ ){

            if (d < 0){
                next = actual - d;
                actual = next;
            } else {
                next = actual + d;
                actual = next;
            }

            System.out.println(next);

        }

    }
    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduzca el primer término de la progresión aritmética: ");
        float term1 = teclado.nextFloat();

        System.out.print("Introduzca la diferéncia de la progresión aritmética: ");
        float diferencia = teclado.nextFloat();

        System.out.print("Introduzca el número de términos de la progresión aritmética: ");
        float num_terminos = teclado.nextFloat();

        writeArithmeticProgression(term1, diferencia, num_terminos);

    

    }
}