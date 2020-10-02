import java.util.Scanner;

public class Program{

    public static void gcd(int n1, int n2){

        boolean salir = false;
        int mcd = 0;
        int contador = 0;
        int menor; //Para no hacer tantas vueltas en el bucle

        if (n1 <= n2){
            menor = n1;
        } else {
            menor = n2;
        }

        for (int i = 1; i <= menor; i++){
            
            if (n1%i == 0 && n2%i == 0){
                mcd = i;
            }
        }


        System.out.println("El máximo común divisor de " + n1 + " y " + n2 + " es: " + mcd);

    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduzca un número entero y positivo: ");
        int num1 = teclado.nextInt();

        System.out.print("Introduzca otro número entero y positivo: ");
        int num2 = teclado.nextInt();

        if (num1 < 0 || num2 < 0){

            System.out.println("Error: se ha introducido algún número negativo");

        } else {
            gcd(num1, num2);
        }

        
    }
}