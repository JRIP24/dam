import java.util.Scanner;

public class Program{

    static double add(double n1, double n2){
        
        double resultado_sum = n1 + n2;

        return resultado_sum;
    }

    static double subtract(double n1, double n2){
        
        double resultado_res = n1 - n2;

        return resultado_res;
    }

    static double multiply(double n1, double n2){
        
        double resultado_mult = n1 * n2;

        return resultado_mult;
    }

    static double divide(double n1, double n2){
        
        double resultado_div = n1 / n2;

        return resultado_div;
    }

    public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        double num1;
        double num2;

        System.out.print("Introduzca un número: ");
        num1 = teclado.nextDouble();

        System.out.print("Introduzca otro número: ");
        num2 = teclado.nextDouble();

        System.out.print(""); //Salto de línea
        System.out.print(""); //Salto de línea

        System.out.println("Resultado de suma: " + add(num1, num2));
        System.out.println("Resultado de resta: " + subtract(num1, num2));
        System.out.println("Resultado de multiplicación: " + multiply(num1, num2));
        System.out.println("Resultado de división: " + divide(num1, num2));

        
     

    }
}