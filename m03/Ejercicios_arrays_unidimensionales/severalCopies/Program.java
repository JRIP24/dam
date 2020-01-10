import java.util.Arrays;
import java.util.Scanner;

public class Program{

    static void severalCopies(int[] num){

        boolean repeticiones = false;

        for(int i = 0; i < num.length; i++){

            for (int x = 0; x < num.length; x++){


                System.out.println("x: " + num[x]);
                System.out.println("i: " + num[i]);
                
                if (num[i] == num[x]){
                    repeticiones = true;
                }
            }
            

        }

        if (repeticiones == true){

            System.out.println("Se ha encontrado algún número repetido en la tabla numérica");
        } else {
            System.out.println("No se ha encontrado un número repetido");
        }
        
    }


    public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        int resultado;

        int[] numeros = new int[6];
        int n;

        for (int i = 0; i < numeros.length; i++){

            System.out.print("Introduzca un número: ");
            n = teclado.nextInt();

            numeros[i] = n;
        }

        System.out.println("");//Salto de línea

        severalCopies(numeros);

    }
}