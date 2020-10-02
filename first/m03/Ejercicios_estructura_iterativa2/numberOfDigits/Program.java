import java.util.Scanner;

public class Program{


    public static void numberOfDigits(int n){

        int numero = n;
        int contador = 0;
        
        while (numero > 0){

            numero = numero / 10;
            contador++;
        }

        if (contador == 1){

            System.out.println("El número " + n + " tiene " + contador + " dígito");
        } else {
            System.out.println("El número " + n + " tiene " + contador + " dígitos");
        }
        
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce un número: ");
        int num = teclado.nextInt();

        if (num < 0){

            System.out.println("Error: el número introducido es negativo");
            
        } else {
            numberOfDigits(num);
        }
    }
}