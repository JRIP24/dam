import java.util.Scanner;


public class ProgramTUI{

    static String rotationPeriod( double dist){

        double t = (2 * Math.PI * Math.pow(6371000 + dist, 1.5)) / (6371000 * Math.sqrt(9.81));
        
        double hor=t/3600;
        double min=(t-(3600*hor))/60;
        
        return ("El periodo de rotación será: " + (int)hor + "h" + "y" + (int)min + "m");
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        double distancia;
        String periodo_rotacion;

        System.out.print("Introduzca la distancia del salélite a la superfície terrestre: ");
        distancia = teclado.nextDouble();

        periodo_rotacion = rotationPeriod(distancia);

        System.out.println(periodo_rotacion);

    }

}