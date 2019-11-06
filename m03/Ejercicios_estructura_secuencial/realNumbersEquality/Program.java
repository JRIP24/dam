import java.util.Scanner;

public class Program{

    static boolean areEquals( double n1, double n2, double t){

        return ((n1 == n2) || (n1 == n2 + t) || (n1 == n2 - t));
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        double num1;
        double num2;
        double t_error;
        boolean resultado;

        System.out.print("Introduzca un número: ");
        num1 = teclado.nextDouble();

        System.out.print("Introduzca otro número: ");
        num2 = teclado.nextDouble();

        System.out.print("Introduzca la toleráncia de error: ");
        t_error = teclado.nextDouble();

        resultado = areEquals(num1, num2, t_error);

        if (resultado == true){
            System.out.println("Los números son iguales");
        } else {
            System.out.println("Los números son diferentes");
        }

    }
}