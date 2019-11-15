import java.util.Scanner;

public class Program{

    public static String max4(double n1, double n2, double n3, double n4 ){

        String mensaje;

        if (n1 >= n2 && n1 >= n3 && n1 >= n4){
            
            mensaje = "El mayor es " + n1;

        } else if (n2 >= n3 && n2 >= n4){
            
            mensaje = "El mayor es " + n2;

        } else if (n3 >= n4){

            mensaje = "El mayor es " + n3;

        } else {
            
            mensaje = "El mayor es " + n4;
        }

        return mensaje;
    }


    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        double numero1;
        double numero2;
        double numero3;
        double numero4;


        System.out.print("Introduzca un número: ");
        numero1 = teclado.nextDouble();

        System.out.print("Introduzca otro número: ");
        numero2 = teclado.nextDouble();

        System.out.print("Introduzca otro número: ");
        numero3 = teclado.nextDouble();

        System.out.print("Introduzca otro número: ");
        numero4 = teclado.nextDouble();

        System.out.println(max4(numero1, numero2, numero3, numero4));
    }
}