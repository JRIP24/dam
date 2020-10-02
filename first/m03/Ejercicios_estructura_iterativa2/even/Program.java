import java.util.Scanner;

public class Program{


    public static void isEven(int n){

        int numero = n;
        
        while (numero > 0){

            numero = numero - 2;
        }

        if (numero == 0){
            System.out.println("El número " + n + " es par");
        } else {
            System.out.println("El número " + n + " es impar");
        }
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce un número: ");
        int num = teclado.nextInt();

        if (num < 0){

            System.out.println("Error: el número introducido es negativo");
            
        } else {
            isEven(num);
        }
    }
}