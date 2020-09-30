import java.util.Arrays;
import java.util.Scanner;

public class ProgramTUI{

    public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        int num;

        System.out.print("¿Cuántos números desea ingresar?: ");
        num = teclado.nextInt();

        float[] numeros = new float[num];
        float n;

        for (int i = 0; i < numeros.length; i++){

            System.out.print("Introduzca un número: ");
            n = teclado.nextFloat();

            numeros[i] = n;

            System.out.println("El número introducido es: " + numeros[i]);

        }



    }
}