import java.util.Scanner;

public class Program{

    static double miles2meters( double mill){

        double met = mill * 1852;

        return met;
    }

    public static void main( String[] args){

        Scanner teclado = new Scanner(System.in);

        double millas;
        double metros;

        System.out.print("Indique el valor en millas: ");
        millas = teclado.nextDouble();

        metros = miles2meters(millas);

        System.out.println( millas + " millas marinas equivalen a " + metros + " metros");

    }

}