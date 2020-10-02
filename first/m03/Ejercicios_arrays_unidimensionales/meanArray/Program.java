import java.util.Arrays;
import java.util.Scanner;

public class Program{

    static float meanArray(float[] num){

        float suma = 0;

        for(int i = 0; i < num.length; i++){

            suma = suma + num[i];
        }

        return suma/num.length;

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

        resultado = meanArray(numeros);

        System.out.printf("La media aritmética de los números introducidos es: %.2f\n", resultado);


    }
}