import java.util.Scanner;

public class Program {

    static boolean isInteger( double num){

        return num%1 == 0;
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        double numero;
        boolean resultado;

        System.out.print("Introduzca un número: ");
        numero = teclado.nextDouble();

        resultado = isInteger(numero);

        if (resultado == true){
            System.out.println("El número introducido es entero");
        } else {
            System.out.println("El número no es entero");
        }


    }
}