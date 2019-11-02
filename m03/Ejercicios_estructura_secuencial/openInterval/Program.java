import java.util.Scanner;

public class Program{

    static String isInOpenInterval( double num1, double num2, double num3){

        String mensaje;

        if ((num3 > num1 && num3 < num2) || (num3 > num2 && num3 < num1)){
            
            mensaje = "El número " + num3 + " se encuentra en el intervalo " + num1 + "-" + num2;

        } else {

            mensaje = "El número " + num3 + " no se encuentra en el intervalo de los números introducidos";
        }

        return mensaje;
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        double numero_1;
        double numero_2;
        double numero_3;
        String resultado;

        System.out.print("Introduzca un número: ");
        numero_1 = teclado.nextDouble();

        System.out.print("Introduzca otro número: ");
        numero_2 = teclado.nextDouble();

        System.out.print("Introduzca el último número: ");
        numero_3 = teclado.nextDouble();

        resultado = isInOpenInterval( numero_1, numero_2, numero_3);

        System.out.println(resultado);



    }

}