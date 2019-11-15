import java.util.Scanner;

public class Program{

    public static double round(double n1, double n2){

        double n1_int;
        double resultado;
        
        resultado = n1;

        n1_int = Math.floor(resultado);
        
        resultado=(resultado-n1_int)*Math.pow(10, n2);
        
        resultado=Math.round(resultado);
        
        resultado=(resultado/Math.pow(10, n2))+n1_int;
        
        return resultado;

    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        double num1;
        double num2;

        System.out.print("Introduzca un número decimal: ");
        num1 = teclado.nextDouble();

        System.out.print("Introduzca el número de decimales que desea redondear: ");
        num2 = teclado.nextDouble();

        System.out.println(round(num1, num2));

    }
}