import java.util.Scanner;

public class Program {


    static int isInteger( double num){

        if (num%1 == 0){
            return 1; //El número es entero
        } else {
            return 0; //El número no es entero
        }
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        double numero;
        int resultado;

        System.out.print("Introduzca un número: ");
        numero = teclado.nextDouble();

        resultado = isInteger(numero);

        if (resultado == 1){
            System.out.println("El número introducido es entero");
        } else {
            System.out.println("El número no es entero");
        }


    }
}