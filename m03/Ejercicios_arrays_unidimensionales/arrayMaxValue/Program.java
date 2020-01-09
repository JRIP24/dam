import java.util.Arrays;
import java.util.Scanner;

public class Program{

    public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);

        float[] numeros = new float[6];
        float n;

        for (int i = 0; i < numeros.length; i++){

            System.out.print("Introduzca un número: ");
            n = teclado.nextFloat();

            numeros[i] = n;
        }

        Arrays.sort(numeros);

        System.out.println("La suma de los números introducidos es: " + numeros[6-1]);//El número máximo menos 1, ya que se comienza a contar por 0




    }
}