import java.util.Scanner;

public class Program{


    public static void writeRandomNumbers(int n1, int n2, int x){

        if (n1 < n2){

            for (int i = 0; i <= x; i++){

                Math.floor(Math.random()*(N-M+1)+M);
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

        System.out.print("Introduzca otro número: ");
        int repeticiones = teclado.nextInt();

        if (num1 == num2 || num1 < 0 || num2 < 0){

            System.out.println("Los número son iguales o negativos");

        }else {
            writeRandomNumbers(num1, num2, repeticiones);
        }

    }
}