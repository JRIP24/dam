import java.util.Scanner;
import java.util.Arrays;

public class Program{


    static void multipleLast(int[] nums){

        int contador = 0;
        int ultimo = nums[nums.length -1];

        System.out.println(ultimo);

        for (int i = 0; i < nums.length; i++){
            
            if (nums[i]%ultimo == 0){
                contador++;
            }
        }

        /**
             int[] i = new int[10];
        The above snippet mean that the array of integers has a length of 10. It's not possible add an eleventh integer, without re-assign the reference to a new array, like the following:

            int[] i = new int[11];
        
         */

        if (contador == 0){

            System.out.println("No se han encontrado múltiples de " + ultimo);

        } else {

            int multiples = new int[contador];

            for (int i = 0; i < nums.length; i++){
                
                if (nums[i]%ultimo == 0){
                    
                }
            }
        }


    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        int[] numeros = new int[6];
        int n;

        for (int i = 0; i< numeros.length; i++){

            System.out.print("Introduzca un número: ");
            n = teclado.nextInt();

            numeros[i] = n;
        }

        multipleLast(numeros);


    }
}
