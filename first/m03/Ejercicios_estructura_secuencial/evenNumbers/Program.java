import java.util.Scanner;

public class Program{

    static boolean isEven( double num){

        return num%2 == 0;
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        double numero;
        boolean resultado;

        System.out.print("Introduzca un número: ");
        numero = teclado.nextDouble();

        resultado = isEven(numero);

        if (resultado == true){

            System.out.println("El número introducido es par");

        } else{
            System.out.println("El número introducido es impar");
        }


    }

}