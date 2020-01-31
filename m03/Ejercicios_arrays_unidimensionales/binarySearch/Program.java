import java.util.Scanner;
import java.util.Arrays;

public class Program{

    static void binarySearch(int[] nums, int n){

        int mayor = nums.length -1;
        int menor = 0;
        boolean salir = false;
        boolean encontrado = false;
        int medio = 0;

        while(salir == false){

            System.out.println("--------------------------VUELTA---------------------------");
            System.out.println("Valor de medio: " + medio );
            System.out.println("Valor de menor: " + menor );
            System.out.println("Valor de mayor: " + mayor );
            System.out.println("");

            medio = (menor + mayor) / 2;

            if (n > nums[medio]){
                
                menor = medio + 1;

            } else if (n < nums[medio]) {
                mayor = medio - 1;

            } else {
                encontrado = true;
            }

            if (encontrado == true || medio <= 0 ){
                salir = true;
            }    

        }

        if (encontrado == true){
            System.out.println("Se ha encontrado el número introducido");
        } else {
            System.out.println("El número introducido no se encuentra en el array");
        }




    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        //int[] numeros = new int[7];
        int[] numeros = {2,3,5,8,10,12,33};
        int num;
/*
        for(int i = 0; i < numeros.length; i++){

            System.out.print("Introduzca un número para el array: ");
            numeros[i] = teclado.nextInt();
        }*/

        Arrays.sort(numeros);

        System.out.println("");//Salto de línea
        System.out.println("Array introducido");
        System.out.println(Arrays.toString(numeros));

        System.out.println("");//Salto de línea
        System.out.print("Introduzca un número: ");
        num = teclado.nextInt();
        System.out.println("");//Salto de línea

        binarySearch(numeros, num);

    }
}