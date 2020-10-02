import java.util.Scanner;
import java.util.Arrays;


public class Program{

    static void sortWords(String[] pal){

        Arrays.sort(pal);
        System.out.println(Arrays.toString(pal));
        
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        String[] palabras = new String[5];

        for(int i = 0; i < palabras.length; i++){
            
            System.out.print("Introduzca una palabra: ");
            palabras[i] = teclado.nextLine();
        }

        System.out.println("");//Salto de línea

        System.out.println("Array: ");
        System.out.println(Arrays.toString(palabras));

        System.out.println("");
        System.out.println("Array ordenado: ");
        sortWords(palabras);

    }
}