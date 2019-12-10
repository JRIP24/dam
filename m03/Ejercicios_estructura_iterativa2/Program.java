import java.util.Scanner;

public class Program{


    public static int maxDivisor(int n){
        int resultado = 1;
        int i = 2;
        int root = (int)Math.sqrt(n);

        while(i < root +1){

            if (n % i == 0){
                resultado = n / i;
                break;
            }

            i++;
        }

        return resultado;
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Introduce un número entero y positivo: ");
        int numero = teclado.nextInt();

        System.out.println("Máximo divisor = " + maxDivisor(numero));
    }
}