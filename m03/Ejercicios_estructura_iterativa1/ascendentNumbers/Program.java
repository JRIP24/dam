import java.util.Scanner;

public class Program{


    public static void writeAscNumbers(int n1, int n2){


        if (n1 < n2){

            for (int i = n1; i <= n2; i++){

                System.out.println(i);
            }

        } else {
            System.out.println("El segundo número es menor que el primero");
        }


    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Introduzca un número: ");
        int num1 = teclado.nextInt();

        System.out.print("Introduzca otro número: ");
        int num2 = teclado.nextInt();

        if (num1 == num2){

            System.out.println("Los número son iguales");

        }else {
            writeAscNumbers(num1, num2);
        }

    }
}