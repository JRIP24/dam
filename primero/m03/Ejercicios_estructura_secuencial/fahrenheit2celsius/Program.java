import java.util.Scanner;

public class Program{

    static double fahrenheit2celsius(double g_f){
        double g_c = (g_f-32)/1.8;

        return g_c;
    }


    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        double grados_f;

        System.out.println("Indique la temperatura en ºF");
        grados_f = teclado.nextDouble();
        double grados_c = fahrenheit2celsius(grados_f);

        System.out.println(grados_f + "ºF es equivalente a " + grados_c + "ºC");
    }
}