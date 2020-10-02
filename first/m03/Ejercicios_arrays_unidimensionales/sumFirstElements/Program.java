import java.util.Arrays;
import java.util.Scanner;

public class Program{

    static void sumFirstElements(float[] num, int n){

        if (n > num.length -1){
            System.out.println("Error: El valor de x supera la longitud de la tabla");
        } else{

            float suma = 0;

            System.out.println("Estos son los primeros " + n + " números: ");

            for(int i = 0; i < n; i++){     
                
                System.out.printf("- %.0f ", num[i]);    
                suma += num[i];
            }


            System.out.println("");//Salto de línea

            System.out.println("Su suma es: " + suma);

        }
        
    }


    public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        float resultado;
        int x;
        float[] numeros = new float[6];
        float n;

        for (int i = 0; i < numeros.length; i++){

            System.out.print("Introduzca un número: ");
            n = teclado.nextFloat();

            numeros[i] = n;
        }

        System.out.println("");//Salto de línea
        System.out.println("A continuación se mostrarán los primeros x números de la tabla numérica anterior ");
        System.out.print("Escriba del valor de x: ");
        x = teclado.nextInt();


        System.out.println("");//Salto de línea

        sumFirstElements(numeros, x);

    }
}