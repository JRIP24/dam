import java.util.Arrays;
import java.util.Scanner;

public class Program{

    static void severalCopies(int[] num){

        int contador = 0;

        for(int i = 0; i < num.length; i++){

            for (int x = 0; x < num.length; x++){

                if (num[i] == num[x]){
                    contador++;
                }
            }

            contador--;//Se resta uno porque obviamnte va a haber una coincidencia

        }

        if (contador > 1){

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