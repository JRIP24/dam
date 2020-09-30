import java.util.Scanner;

public class Program {
    
    static float area( float b, float a){
        return (b*a) / 2;
    }

    public static void main( String[] args){
        // Creamos el objeto scaner, para leer datos por teclado
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Introduzca la base del triángulo");
        float base = teclado.nextFloat();

        System.out.println("Introduzca la altura del triángulo");
        float altura = teclado.nextFloat();

        float calc_area = area(base, altura);
        System.out.printf("El área del triángulo es: %.2f\n",calc_area);
    }
}