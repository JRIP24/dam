import java.util.Scanner;

public class Program{


    public static void mySqrt(int n){

        int contador = 0;
        String salir = "no";
        int raiz = 0;

        
        while( salir == "no"){

            raiz = contador * contador;

            if (raiz == n){

                salir = "si";

            } else if (raiz > n){
                contador = contador - 1;
                raiz = contador * contador;
                salir = "si";
            } else {

                contador++;
            }
        }

        System.out.println("La raíz cuadrada de " + n + " es: " + contador);

        
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce un número entero positivo: ");
        int num = teclado.nextInt();


        if (num < 0){

            System.out.println("Error: El número introducido es negativo");

        } else {

            mySqrt(num);
        }

        
    }
}