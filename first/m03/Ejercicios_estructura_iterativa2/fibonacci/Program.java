import java.util.Scanner;

public class Program{


    public static void fibonacci(int n){

        int fibo1 = 0;
        int fibo2 = 1;
        int fibo = 0;
        boolean salir = false;

        if ( n == 0){

            System.out.print(fibo1 + " ");

        } else if (n == 1) {

            System.out.print(fibo1 + " ");
            System.out.print(fibo2 + " ");
            salir = true;
        } else {
            System.out.print(fibo1 + " ");
            System.out.print(fibo2 + " ");
        }


        while( salir == false){

            if (fibo != 0){
                System.out.print(fibo + " ");
            }
            

            fibo = fibo1 + fibo2;
            fibo1 = fibo2;
            fibo2 = fibo;


            //Condición de saida
            if (fibo > n){
                salir = true;
            }

        }

        System.out.println("");//Salto de línea
        
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce un número entero positivo: ");
        int num = teclado.nextInt();


        if (num < 0){

            System.out.println("Error: Se ha introducido un número negativo");

        } else {

            fibonacci(num);
        }

        
    }
}