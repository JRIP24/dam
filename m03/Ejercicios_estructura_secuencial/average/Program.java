import java.util.Scanner;

public class Program {
    
    static float average( float n1, float n2, float n3){
        return (n1 + n2 + n3) / 3;
    }

    public static void main( String[] args){
        // Creamos el objeto scaner, para leer datos por teclado
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Introduce un número");
        float num1 = teclado.nextFloat();

        System.out.println("Introduce otro número");
        float num2 = teclado.nextFloat();

        System.out.println("Introduce otro número");
        float num3 = teclado.nextFloat();

        float media = average(num1, num2, num3);
        System.out.println("La media de los números introducidos es: " + media);
    }
}