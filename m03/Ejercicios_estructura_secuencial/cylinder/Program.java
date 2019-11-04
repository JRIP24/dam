import java.util.Scanner;

public class Program{

    static double volume(double rad, double alt){
        
        double resultado_vol = Math.PI * Math.pow(rad, 2) * alt;

        return resultado_vol;
    }

    static double area(double rad, double alt){
        
        double resultado_ar = 2 * Math.PI * rad * alt;

        return resultado_ar;
    }


    public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        double radio;
        double altura;
        double volumen;
        double area_cilindro;

        System.out.print("Introduzca el radio del cilindro: ");
        radio = teclado.nextDouble();

        System.out.print("Introduzca la altura del cilindro: ");
        altura = teclado.nextDouble();

        volumen = volume(radio, altura);
        area_cilindro = area(radio, altura);

        System.out.printf("Volumen del cilindro: %.2f \n", volumen);
        System.out.printf("Área del cilindro: %.2f \n", area_cilindro);
    }
}