import java.util.Scanner;

public class Program{

    static double max2(double n1, double n2){

        double mayor;

        if (n1 > n2){

            mayor = n1;

        } else {
            
            mayor = n2;
        }

        return mayor;
    }


    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        double numero1;
        double numero2;

        System.out.print("Introduzca un número: ");
        numero1 = teclado.nextDouble();

        System.out.print("Introduzca otro número: ");
        numero2=teclado.nextDouble();

        if (numero1 == numero2){

            System.out.println("Los números són iguales");

        } else{
            
            System.out.println("El número mayor es: " + max2(numero1, numero2));
        }



    }

}