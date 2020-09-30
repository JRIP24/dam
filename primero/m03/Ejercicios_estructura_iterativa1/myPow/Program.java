import java.util.Scanner;

public class Program{


    public static void myPow(int n1, int n2){

        int potencia = 1;

        for (int i = 1; i <= n2; i++){

            potencia = potencia * n1;
            
        }

        System.out.println("La potencia de " + n1 + " elevado a " + n2 + " es: " + potencia );
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Introduce el número base: ");
        int num1 = teclado.nextInt();

        System.out.print("Introduce el número exponente: ");
        int num2 = teclado.nextInt();

        if ( num2 < 0){

            System.out.println("Error: El exponente es negativo");

        }else {
            myPow(num1, num2);
        }

    }
}