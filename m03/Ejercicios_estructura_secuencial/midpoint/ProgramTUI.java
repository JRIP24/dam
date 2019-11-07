import java.util.Scanner;

public class ProgramTUI{

    static String average2(double ax, double ay, double bx, double by){

        double p1 = (ax + bx) / 2;
        double p2 = (ay + by)/2;

        return "(" + (int)p1 + "," + (int)p2 + ")";

    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        double a_x;
        double a_y;
        double b_x;
        double b_y;
        String punto_medio;


        System.out.print("Introduce el punto x de la primera coordenada: ");
        a_x = teclado.nextDouble();

        System.out.print("Introduce el punto y de la primera coordenada: ");
        a_y = teclado.nextDouble();

        System.out.println("");//Salto de línea

        System.out.print("Introduce el punto x de la segunda coordenada: ");
        b_x = teclado.nextDouble();

        System.out.print("Introduce el punto y de la segunda coordenada: ");
        b_y = teclado.nextDouble();

        punto_medio = average2(a_x, a_y, b_x, b_y);

        System.out.println("El punto intermedio es: " + punto_medio);

    }
}