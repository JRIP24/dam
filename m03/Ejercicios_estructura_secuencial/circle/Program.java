import java.util.Scanner;

public class Program{

    static double perimeter(double rad){
        
        double resultado_per = 2 * Math.PI * rad;

        return resultado_per;
    }

    static double area(double rad){
        
        double resultado_ar = Math.PI * Math.pow(rad, 2);

        return resultado_ar;
    }


    public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        double radio;
        double permimetro;
        double area_circulo;

        System.out.print("Introduzca el radio del círculo: ");
        radio = teclado.nextDouble();

        permimetro = perimeter(radio);
        area_circulo = area(radio);

        System.out.printf("Perímetro del círculo: %.2f \n", permimetro);
        System.out.printf("Área del círculo: %.2f \n", area_circulo);
    }
}