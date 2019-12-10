import java.util.Scanner;


public class Program{


    public static void checkNarcissisticNumbers(int a, int b, int c){

        int sumaCubs = a*a*a + b*b*b + c*c*c;
        int numero = a*100 + b*10 + c;

        if (sumaCubs == numero){
            System.out.println(numero);
        }
        
    }

    public static void writeNarcissisticNumbers(){
        
        for (int i = 1; i <= 9; i++){

            for (int j = 0; j <= 9; j++){

                for (int k = 0; k <= 9; k++){
                    checkNarcissisticNumbers(i, j, k);
                }
            }
        }
    }

    public static void main(String[] args){
        

        Scanner teclado = new Scanner(System.in);
        
        /*System.out.print("Introduzca un número: ");
        int num1 = teclado.nextInt();

        System.out.print("Introduzca otro número: ");
        int num2 = teclado.nextInt();

        System.out.print("Introduzca otro número: ");
        int num3 = teclado.nextInt();*/

        writeNarcissisticNumbers();
    }
}