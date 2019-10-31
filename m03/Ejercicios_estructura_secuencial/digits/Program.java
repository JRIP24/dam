import java.util.Scanner;

public class Program{

    static int digitPosition(int n1, int n2){

        int resultat = 0;

        if (n2 > 1){
            for (int i = 1; i < n2; i ++ ){
                n1 = n1/10;
                System.out.println("Valor de n1 " + n1);
            }
        }

        resultat = n1%10;

        return resultat;
    }

    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        int num1;
        int num2;

        System.out.println("Introduzca el primer número entero no negativo: ");
        num1 = teclado.nextInt();

        System.out.println("Introduzca el segundo número entero no negativo: ");
        num2 = teclado.nextInt();

        int resultado = digitPosition(num1, num2);

        System.out.println(resultado);
    }

}