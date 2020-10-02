import java.util.Scanner;

public class Program{

    static int flightTime(double vel_ini, double a_ini){

        double t = (2 * vel_ini * Math.sin(a_ini))/9.81;

        int time = (int)t;

        return time;
    }

    static int distance(double vel_ini, double a_ini){

        double d = (Math.pow(vel_ini, 2) * Math.sin(2 * a_ini))/9.81;

        int dist = (int)d;

        return dist;

    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        double velocidad_inicial;
        double angulo_inicial;
        int tiempo_vuelo;
        int distancia_impacto;

        System.out.print("Introduzca la velocidad inicial del proyectil (m/s): ");
        velocidad_inicial = teclado.nextDouble();

        System.out.print("Introduzca el ángulo de tiro del proyectil: ");
        angulo_inicial = teclado.nextDouble();

        tiempo_vuelo = flightTime(velocidad_inicial, angulo_inicial);

        distancia_impacto = distance(velocidad_inicial, angulo_inicial);

        System.out.println("");//Salto de línea

        System.out.println("Tiempo de vuelo del proyectil: " + tiempo_vuelo + "s");
        System.out.println("Distancia de impacto del proyectil: " + distancia_impacto + "m");



    }

}