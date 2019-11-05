import java.util.Scanner;

public class Program{

    static int digitPosition(int n1, int n2){

        /*
        int resultat = 0;

        if (n2 > 1){
            for (int i = 1; i < n2; i ++ ){
                n1 = n1/10;
            }
        }

        resultat = n1%10;

        return resultat;*/

        int a = n1;
        int b = (int)Math.pow(10, n2);
        
        int c = (int)Math.pow(10, n2 - 1);

        int resultat_1 = a / c;
        int resultat_2 = (a/b)*10;

        return resultat_1 - resultat_2;

    }

    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        int num1;
        int num2;

        System.out.print("Introduzca el primer número entero no negativo: ");
        num1 = teclado.nextInt();

        //Definimos la longitud del primer número
        String longitud = Integer.toString(num1);

        System.out.print("Introduzca el segundo número entero no negativo: ");
        num2 = teclado.nextInt();

        if(num2 <= 0){

            System.out.println("ERROR: No se aceptan números negativos o 0");

        } else if ( num2 > longitud.length()){

            System.out.println("ERROR: El segundo número es mayor que la longitud del primer número");

        } else {
            
            int resultado = digitPosition(num1, num2);

            System.out.println("Resultado: " + resultado);
        }
    }

}