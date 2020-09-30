import java.util.Arrays;
import java.util.Scanner;

public class Program{

    static void equalLength(int[] nums1, int[] nums2){


        if (nums1.length == nums2.length){
            System.out.println("Las tablas numéricas tienen la misma medida");
        } else {
            System.out.println("Las medidas de las tablas numéricas son diferentes");
        }
   
    }


    public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);

        int medida_arrays = 6;
        int[] numeros1 = new int[2];
        int[] numeros2 = new int[medida_arrays];
        int n;



        //Primera tabla numérica
        System.out.println("");//Salto de línea
        System.out.println("Números para la primera tabla numérica");

        for (int i = 0; i < numeros1.length; i++){

            System.out.print("Introduzca un número: ");
            n = teclado.nextInt();

            numeros1[i] = n;
        }

        //Segunda tabla numérica
        System.out.println("");//Salto de línea
        System.out.println("Números para la segunda tabla numérica");

        for (int i = 0; i < numeros2.length; i++){

            System.out.print("Introduzca un número: ");
            n = teclado.nextInt();

            numeros2[i] = n;
        }

        System.out.println("");//Salto de línea
        equalLength(numeros1, numeros2);

    }
}