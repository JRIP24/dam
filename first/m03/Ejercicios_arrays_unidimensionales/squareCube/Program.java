import java.util.Arrays;
import java.util.Scanner;

public class Program{

    static void writeSquareCube(int[] num){

        int cuadrado, cubo;

        for(int i = 0; i < num.length; i++){


            cuadrado = (int)Math.pow(num[i],2);
            cubo = (int)Math.pow(num[i],3);

            System.out.println("Cuadrado de " + num[i] + ": " + cuadrado);
            System.out.println("Cubo de " + num[i] + ": " + cubo);
            System.out.println("");//Salto de línea
        }
        
    }


    public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        int resultado;

        int[] numeros = new int[6];
        int n;

        for (int i = 0; i < numeros.length; i++){

            System.out.print("Introduzca un número: ");
            n = teclado.nextInt();

            numeros[i] = n;
        }

        System.out.println("");//Salto de línea

        writeSquareCube(numeros);

    }
}