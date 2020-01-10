import java.util.Arrays;
import java.util.Scanner;

public class Program{

    static void modulus(int[] num){

        int suma = 0;

        for(int i = 0; i < num.length; i++){

            suma = suma + (int)Math.pow(num[i],2);
        }

        float raiz = (float)Math.sqrt(suma);

        System.out.printf("El módulo del vector es: %.2f\n", raiz);
        
    }


    public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        int resultado;

        int[] numeros = new int[3];
        int n;

        for (int i = 0; i < numeros.length; i++){

            System.out.print("Introduzca un número: ");
            n = teclado.nextInt();

            numeros[i] = n;
        }

        System.out.println("");//Salto de línea

        modulus(numeros);

    }
}