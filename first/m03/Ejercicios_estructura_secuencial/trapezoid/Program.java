import java.util.Scanner;

public class Program{

    static double area( double b1, double b2, double a ){
        double calc_area = ((b1 + b2)/2) * a;

        return calc_area;
    }


    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        double base1;
        double base2;
        double altura;
        double area_trapecio;


        System.out.print("Indique la primera base del trapecio: ");
        base1 = teclado.nextDouble();

        System.out.print("Indique la segunda base del trapecio: ");
        base2 = teclado.nextDouble();

        System.out.print("Indique la altura del trapecio: ");
        altura = teclado.nextDouble();

        area_trapecio = area( base1, base2, altura);

        System.out.println("El área del trapecio es: " + area_trapecio);


    }

}