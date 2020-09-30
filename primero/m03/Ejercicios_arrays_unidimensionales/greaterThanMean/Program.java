import java.util.Arrays;
import java.util.Scanner;

public class Program{

    static float percentageGreaterThanMean(float[] num){

        float suma = 0;
        float media;
        float contador = 0;

        for(int i = 0; i < num.length; i++){

            suma = suma + num[i];
        }

        media = suma/num.length;

        for(int i = 0; i < num.length; i++){

            if (num[i] > media){
                contador++;
            }
        }

        return (contador/num.length)*100;

    }


    public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        float resultado;

        float[] numeros = new float[6];
        float n;

        for (int i = 0; i < numeros.length; i++){

            System.out.print("Introduzca un número: ");
            n = teclado.nextFloat();

            numeros[i] = n;
        }

        resultado = percentageGreaterThanMean(numeros);

        System.out.println("El " + resultado + "%" + " de los números introducidos es mayor que la media de la tabla de números");


    }
}