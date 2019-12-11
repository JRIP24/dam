import java.util.Scanner;

public class Program{


    public static void numberOfEvenNumbers(int n1, int n2){

        if (n1 < n2){

            int contador = 0;

            for (int i = n1; i <= n2; i++){

                if ( i%2 == 0){
                    contador++;
                }
            }

            System.out.println("Entre " + n1 + " y " + n2 + " hay " + contador + " números pares");

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

        if (num1 == num2 || num1 < 0 || num2 < 0){

            System.out.println("Los número son iguales o negativos");

        }else {
            numberOfEvenNumbers(num1, num2);
        }

    }
}