import java.util.Scanner;

public class Program{

    static double abs(double num){

        double valor_absoluto;

        if ( num >= 0){
            
            valor_absoluto = num;
            
        } else{

            valor_absoluto = - num;
        }

        return valor_absoluto;
    }


    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        double numero;

        System.out.print("Introduzca un número: ");
        numero = teclado.nextDouble();

        System.out.println("El valor absoluto de " + numero + " es: " + abs(numero));


    }

}