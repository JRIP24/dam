import java.util.Scanner;

public class Program{

    public static void isPrime(int n){

        boolean salir = false;

        int contador = 0;

        for (int i = 1; i <= n; i++){
            
            if (n%i == 0){
                contador++;
            }
        }

        if (contador == 2){

            System.out.println("El número " + n + " es primo");

        } else {
            System.out.println("El número introducido no es primo");
        }
    }







    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduzca un número entero: ");
        int num = teclado.nextInt();

        isPrime(num);

        
    }
}