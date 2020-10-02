import java.util.Scanner;

public class Program{


    public static void writeDescNumbers(int n1, int n2){

        if (n1 < n2){

            String i_str;
            int unicode;

            for (int i = n1; i <= n2; i++){

                i_str = Integer.toString(i);
                unicode = Integer.parseInt(i_str, 16);
                System.out.println("Carácter unicode de " + i + " = " + (char)unicode);
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

        if (num1 == num2 || num1 < 0 || num2 < 0){

            System.out.println("Los número son iguales o negativos");

        }else {
            writeDescNumbers(num1, num2);
        }

    }
}