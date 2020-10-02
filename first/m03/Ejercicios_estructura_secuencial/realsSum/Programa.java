import java.util.Scanner;

public class Programa {
    
    static float add( float n1, float n2){
        return n1 + n2;
    }

    public static void main( String[] args){
        // Creamos el objeto scaner, para leer datos por teclado
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Introduce un número");
        float num1 = teclado.nextFloat();

        System.out.println("Introduce otro número");
        float num2 = teclado.nextFloat();

        float suma = add(num1, num2);
        System.out.println("La suma de " + num1 + " y " + num2 + " es: " + suma);
    }
}