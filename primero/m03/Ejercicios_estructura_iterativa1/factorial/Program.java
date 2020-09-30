import java.util.Scanner;

public class Program{


    public static void factorial(int n1){

        int f = 1;

        for (int i = 1; i <= n1; i++){
            f *= i;            
        }

        System.out.println( n1 + "! = " + f);
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Introduce un número: ");
        int num1 = teclado.nextInt();

        if ( num1 <= 0){

            System.out.println("Error: El número es negativo o 0");

        }else {
            factorial(num1);
        }

    }
}