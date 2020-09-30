import java.util.Scanner;
import java.util.Arrays;

public class Program{

    static boolean areSorted(int[] nums){

        boolean ordenados = true;
        boolean salir = false;
        int contador = 0;

        while(salir == false){

            if (nums[contador] > nums[contador + 1]){
                ordenados = false;
            }

            //Incremento
            contador++;
            
            //Condición de salida
            if(ordenados == false || contador >= nums.length -1){
                salir = true;
            }

        }        


        return ordenados;
    }

    public static void main(String[] args){


        Scanner teclado = new Scanner(System.in);

        int[] numeros = new int[7];

        for(int i = 0; i < numeros.length; i++){
            
            System.out.print("Introduzca un número para el array: ");
            numeros[i] = teclado.nextInt();
        }

        System.out.println("");//Salto de línea

        if (areSorted(numeros) == true){
            System.out.println("El array está ordenado de forma creciente");
        } else {
            System.out.println("El array NO está ordenado de forma creciente");
        }

        System.out.println("");//Salto de línea



    }

    
}