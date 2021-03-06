import java.util.Scanner;
import java.util.Arrays;

public class Program{


    static void multipleLast(int[] nums){

        int contador = 0;
        int ultimo = nums[nums.length -1];
        int[] indices = new int[nums.length];

        for (int i = 0; i < nums.length - 1; i++){
            
            if (nums[i]%ultimo == 0){
                contador++;
            }
        }

        if (contador == 0){

            System.out.println("No se han encontrado múltiples de " + ultimo);

        }else {

            int[] multiples = new int[contador];

            for (int i = 0; i < nums.length-1; i++){
                
                if (nums[i]%ultimo == 0){

                    multiples[i] = nums[i];
                    
                }
            }

            System.out.println("Lista de números múñtiples de "  + ultimo + ":");
            System.out.println(Arrays.toString(multiples));
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
