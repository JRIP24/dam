import java.util.Scanner;

public class Program{

    static double celsius2fahrenheit( double g_c){
        
        double g_f = (g_c * 1.8) + 32;
        return g_f;
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        double grados_c;

        System.out.println("Introduzca la temperatura en ºC");
        grados_c = teclado.nextDouble();

        double grados_f = celsius2fahrenheit(grados_c);

        System.out.println( grados_c + "ºC es equvalente a " + grados_f + "ºF");
    }
}