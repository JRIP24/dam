import java.util.Scanner;

public class ProgramTUI{

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        double num1;
        double num2;
        double num3;

        System.out.print("Introduzca valor para la variable num1: ");
        num1 = teclado.nextDouble();

        System.out.print("Introduzca valor para la variable num2: ");
        num2 = teclado.nextDouble();

        System.out.println("");//Salto de línea
        System.out.println("Valor de variable num1: " + num1);
        System.out.println("Valor de variable num2: " + num2);

        System.out.println("");//Salto de línea

        System.out.println("*********************");
        System.out.println("*        SWAP       *");
        System.out.println("*********************");

        num3 = num1;
        num1 = num2;
        num2 = num3;

        System.out.println("");//Salto de línea
        
        System.out.println("Valor de variable num1: " + num1);

        System.out.println("Valor de variable num2: " + num2);

        

    }
}