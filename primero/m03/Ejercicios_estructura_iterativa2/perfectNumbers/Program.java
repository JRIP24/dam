import java.util.Scanner;

public class Program{

    //Función para comprobar si es un número perfecto

    public static boolean checkPerfectNumber(int n){

        int suma = 0;
        for(int i = 1; i < n; i++ ){

            if ( n%i == 0){
                suma += i;
            }
        }

        if (suma == n){

            return true;
        
        } else {
            return false;
        }

    }


    public static void writePrimeNumbers(int n1, int n2){

        boolean resultado = false;

        if (n1 < n2){

            int contador = 0;

            for (int i = n1; i <= n2; i++){

                resultado = checkPerfectNumber(i);

                if (resultado == true) {
                    System.out.print(i + " ");
                }
            }
            System.out.println("");//Salto de línea


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
            writePrimeNumbers(num1, num2);
        }

    }
}