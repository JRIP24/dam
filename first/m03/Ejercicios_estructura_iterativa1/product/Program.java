import java.util.Scanner;

public class Program{


    public static void multiply(int n1, int n2){

        int producto = 0;

        for (int i = 1; i <= n2; i++){

            producto = producto + n1;
            
        }

        System.out.println("El producto de " + n1 + " repetido " + n2 + " veces es: " + producto );
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Introduce un número: ");
        int num1 = teclado.nextInt();

        System.out.print("Introduce otro número: ");
        int num2 = teclado.nextInt();

        if ( num1 < 0 || num2 < 0){

            System.out.println("Los número son negativos");

        }else {
            multiply(num1, num2);
        }

    }
}