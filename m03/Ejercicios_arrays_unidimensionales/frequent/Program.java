import java.util.Arrays;
import java.util.Scanner;

public class Program{

    static void frequent(int[] num){

        int contador = 0;

        for(int i = 0; i < num.length; i++){

            for (int x = 0; x < num.length; x++){

                if (num[i] == num[x]){
                    contador++;
                }
            }

            contador--;//Se resta uno porque obviamnte va a haber una coincidencia

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

        frequent(numeros);

    }
}