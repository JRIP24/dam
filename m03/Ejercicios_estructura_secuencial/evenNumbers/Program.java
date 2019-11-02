import java.util.Scanner;

public class Program{

    static String isEven( double num){

        String mensaje;

        if (num%2 == 0){
            mensaje = "El número introducido es par";
        } else {
            mensaje = "El número introducido es impar";
        }

        return mensaje;
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        double numero;
        String resultado;

        System.out.print("Introduzca un número: ");
        numero = teclado.nextDouble();

        resultado = isEven(numero);

        System.out.println(resultado);



    }

}