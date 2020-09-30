import java.util.Scanner;

public class Program{

    
    static double velocity( double m_s){

        double km_h = m_s * 3.6;

        return km_h;

    }

    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);

        double metros;
        double segundos;
        double velocidad_m_s;
        double velocidad_km_h;

        System.out.print("Indique la distancia en metros: ");
        metros = teclado.nextDouble();

        System.out.print("Indique el timepo en segundos: ");
        segundos = teclado.nextDouble();

        velocidad_m_s = metros/segundos;

        velocidad_km_h = velocity(velocidad_m_s);

        System.out.println("La velocidad de " + velocidad_m_s + "m/s equivale a " + velocidad_km_h + "km/h");






    }
}