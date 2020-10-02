import java.util.Scanner;
import java.util.Arrays;


public class Program{

    static void join(float[] ar1, float[] ar2){

        float[] ar3 = new float[ar1.length + ar2.length];

        for (int i = 0; i < ar1.length; i++){
            ar3[i] = ar1[i];
        }

        int contador = ar1.length;
        for (int i = 0; i < ar2.length; i++){
            
            ar3[contador] = ar2[i];
            contador++;

        }

        System.out.println("Elementos del la tercera tabla numérica: ");
        System.out.println(Arrays.toString(ar3));


    }


    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        float[] nums1 = new float[5];
        float[] nums2 = new float[8];

        for(int i = 0; i < nums1.length; i++){

            System.out.print("Introduzca un número para el primer array: ");
            nums1[i] = teclado.nextFloat();

        }
        
        
        //Segundo array
        for(int i = 0; i < nums2.length; i++){

            System.out.print("Introduzca un número para el segundo array: ");
            nums2[i] = teclado.nextFloat();

        }

        join(nums1, nums2);



    }
}