import java.util.Scanner;
import java.util.Arrays;

public class ProgramTUI{


    static void bubbleSort(float[] nums){

        float aux = 0;
        boolean salir = false;
        boolean arreglado = false;

        while(salir == false){

            for(int i = 0; i < nums.length -1; i++){

                if (nums[i] > nums[i + 1]){

                    aux = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = aux;

                    arreglado = false;

                } else {
                    arreglado = true;
                }
            }

            //Condición de salida
            if (arreglado == true){
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

        System.out.println(Arrays.toString(numeros));
        bubbleSort(numeros);


    }
}