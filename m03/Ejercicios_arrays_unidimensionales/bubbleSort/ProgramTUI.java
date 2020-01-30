import java.util.Scanner;
import java.util.Arrays;

public class ProgramTUI{


    static void bubbleSort(float[] nums){

        float aux = 0;
        boolean salir = false;
        int cont = 0;

        while(salir == false){

            cont = 0;

            for(int i = 0; i < nums.length -1; i++){
                /*
                System.out.println(Arrays.toString(nums));
                System.out.println("valor de i: " + nums[i]);
                System.out.println("valor de i + 1: " + nums[i + 1]);
                System.out.println("");*/

                if (nums[i] > nums[i + 1]){

                    aux = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = aux;


                } else {
                    cont++;
                }



            }

            //Condición de salida
            if (cont >= nums.length - 1){
                salir = true;
            }
        

        }



        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        float[] numeros = new float [5];

        for(int i = 0; i < numeros.length; i++){
            System.out.print("Introduzca un número: ");

            numeros[i] = teclado.nextFloat();
        }

        System.out.println("");//Salto de línea
        System.out.println("Array introducido: ");

        System.out.println(Arrays.toString(numeros));

        System.out.println("");//Salto de línea
        System.out.println("Array ordenado: ");
        bubbleSort(numeros);


    }
}