import java.util.Scanner;

public class ProgramTUI{


    static double flightTime( double dist, double vel){

        return dist / vel;
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        double distancia;
        double vel_media;
        double tiempo;

        System.out.print("Introduzca la distancia entre los aeropuertos (km): ");
        distancia = teclado.nextDouble();

        System.out.print("Introduzca la velocidad media del avión (km/h): ");
        vel_media = teclado.nextDouble();

        tiempo = flightTime(distancia,vel_media);

        System.out.printf("El tiempo de vuelo será %.2fh\n" , tiempo);
    }

}