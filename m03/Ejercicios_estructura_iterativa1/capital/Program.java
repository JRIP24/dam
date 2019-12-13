import java.util.Scanner;

public class Program{


    public static void calculateFinalCapital(int n1, int n2, int n3){

        int capital_acumulado = 0;

        for (int i = 1; i <= n3; i++){
              
        }

        System.out.println();
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);


        System.out.println("*********************************");
        System.out.println("*       NVERSIÓN BANCARIA       *");
        System.out.println("*********************************");


        System.out.print("Introduce el capital inicial: ");
        int num1 = teclado.nextInt();

        System.out.print("Introduce el % de interés: ");
        int num2 = teclado.nextInt();

        System.out.print("Introduce los años de duración: ");
        int num3 = teclado.nextInt();

        if ( num1 <= 0 || num2 < 0 || num3 <= 0 ){

            System.out.println("Error: Ha introducido valores negativos o 0");

        }else {
            calculateFinalCapital(num1, num2, num3);
        }

    }
}