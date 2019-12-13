import java.util.Scanner;

public class Program{


    public static void calculateFinalCapital(float n1, float n2, float n3){

        float capital_anyo = 0;
        float interes = n2/100;

        for (int i = 1; i <= n3; i++){
            
            capital_anyo = n1* (float)Math.pow(1+(n2/100),i);

            System.out.println("Capital del año: " + i + ": " + capital_anyo);
        }

    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce el capital inicial: ");
        float num1 = teclado.nextFloat();

        System.out.print("Introduce el % de interés: ");
        float num2 = teclado.nextFloat();

        System.out.print("Introduce los años de duración: ");
        float num3 = teclado.nextFloat();

        if ( num1 <= 0 || num2 < 0 || num3 <= 0 ){

            System.out.println("Error: Ha introducido valores negativos o 0");

        }else {
            calculateFinalCapital(num1, num2, num3);
        }

    }
}