import java.util.Scanner;

public class Programa {
    
    static int add( int n1, int n2){
        return n1 + n2;
    }

    public static void main( String[] args){
        // Creamos el objeto scaner, para leer datos por teclado
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Introduce un número");
        int num1 = teclado.nextInt();

        System.out.println("Introduce otro número");
        int num2 = teclado.nextInt();

        int suma = add(num1, num2);
        System.out.println("La suma de " + num1 + " y " + num2 + " es: " + suma);
    }
}