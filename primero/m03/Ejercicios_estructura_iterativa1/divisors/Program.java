import java.util.Scanner;

public class Program{


    public static void writeMultiples(int n1){


            for (int i = 1; i <= n1; i++){

                if ( n1%i == 0){
                    System.out.println("El número " + i + " es divisible entre " + n1);
                }
            }
    
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Introduzca un número: ");
        int num1 = teclado.nextInt();

        if (num1 < 0){

            System.out.println("El número introducido es negativo");

        }else {
            writeMultiples(num1);
        }

    }
}