import java.util.Scanner;

public class Program{


    public static void sumEvenNumbers(int n1, int n2){

        if (n1 < n2){

            int suma = 0;

            for (int i = n1; i <= n2; i++){

                if (i%2 == 0){
                    suma = suma + i;
                }
            }

            System.out.println("La suma de los números pares entre " + n1 + " y " + n2 + " es " + suma);

        } else {

            System.out.println("El segundo número es menor que el primero");
        }

    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Introduce un número: ");
        int num1 = teclado.nextInt();

        System.out.print("Introduce otro número: ");
        int num2 = teclado.nextInt();

        if (num1 == num2){

            System.out.println("Los número son iguales");

        }else {
            sumEvenNumbers(num1, num2);
        }

    }
}