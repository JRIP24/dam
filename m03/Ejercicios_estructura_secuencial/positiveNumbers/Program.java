import java.util.Scanner;

public class Program{

    static boolean isPositive( double num){

        return num >= 0;
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        double numero;
        boolean resultado;

        System.out.print("Introduzca un número: ");
        numero = teclado.nextDouble();

        resultado = isPositive(numero);

        if (resultado == true){
            System.out.println("El número introducido es positivo");
        } else {
            System.out.println("El número introducido es negativo");
        }


    }

}