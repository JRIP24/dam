import java.util.Scanner;

public class Program{

    static String isPositive( double num){

        String mensaje;

        if (num >= 0){
            mensaje = "El número introducido es positivo";
        } else {
            mensaje = "El número introducido es negativo";
        }

        return mensaje;
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        double numero;
        String resultado;

        System.out.print("Introduzca un número: ");
        numero = teclado.nextDouble();

        resultado = isPositive(numero);

        System.out.println(resultado);



    }

}