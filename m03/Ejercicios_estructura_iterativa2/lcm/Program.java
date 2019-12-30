import java.util.Scanner;

public class Program{

    public static void lcm(int n1, int n2){

        boolean salir = false;
        int minc = 0;
        int contador = 1;
        int mayor;

        if (n1 > n2){
            mayor = n1;
        } else {
            mayor = n2;
        }

        while (salir == false){

            if (mayor%n1 == 0 && mayor%n2 == 0){
                minc = mayor;
                salir = true;
            } else {
                mayor++;
            }
        }


        System.out.println("El mínimo común múltiple de " + n1 + " y " + n2 + " es: " + minc);

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
            lcm(num1, num2);
        }

        
    }
}