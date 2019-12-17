import java.util.Scanner;

public class Program{


    public static void occurrences(int n, int d){
        
        String salir = "n";
        int contador = 0;
        int numero = n;

        while( numero > 0){

            if (numero%10 == d){
                contador++;
            }

            numero = numero / 10;

        }

        if (contador == 1){
            System.out.println("En el número " + n + "  el dígito " + d + " aparece " + contador + " veces");
        } else {
            System.out.println("En el número " + n + "  el dígito " + d + " aparece " + contador + " veces");
        }

        
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce un número entero positivo: ");
        int num = teclado.nextInt();

        System.out.print("Introduce un dígito: ");
        int digit = teclado.nextInt();


        if (num < 0 || digit < 0){

            System.out.println("Error: Se ha introducido un número negativo");

        } else {

            occurrences(num, digit);
        }

        
    }
}