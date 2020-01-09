import java.util.Arrays;
import java.util.Scanner;

public class Program{

    static float sumArray(float[] num){

        float suma = 0;

        for(int i = 0; i < num.length; i++){

            suma = suma + num[i];
        }

        return suma;


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

        resultado = sumArray(numeros);

        System.out.println("La suma de los números introducidos es: " + resultado);




    }
}