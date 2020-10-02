import java.util.Scanner;

public class Program{


    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce el número de números: ");
        int numero = teclado.nextInt();
        int min = 0;
        int max = 0;
        int actual;


        if (numero > 0){
            System.out.print("Introduce un número: ");
            actual = teclado.nextInt();
            min = actual;
            max = actual;
        }

        for (int i = 1; i < numero; i++){

            System.out.print("Introduce un número: ");
            actual = teclado.nextInt();

            if (actual < min){
                min = actual;
            }

            if (actual > max){
                max = actual;
            }
    }

        System.out.println("Mínimo: " + min);
        System.out.println("Máximo: " + max);

    }

}