import java.util.Scanner;

public class Program{

    public static String sign(double n){
        
        String mensaje;

        if (n > 0){
            
            mensaje = "positiu";

        } else if (n == 0){

            mensaje = "zero";

        } else {
            mensaje = "negatiu";
        }

        return mensaje;
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        double num;

        System.out.print("Introduzca un número: ");
        num = teclado.nextDouble();

        System.out.println(sign(num));

    }
}