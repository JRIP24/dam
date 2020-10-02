import java.util.Scanner;

public class Program{

    public static void isPerfectNumber(int n1, int n2){

        int suma1 = 0;
        int suma2 = 0;

        for(int i = 1; i < n1; i++ ){

            if ( n1%i == 0){
                suma1 += i;
            }
        }

        for(int i = 1; i < n2; i++ ){

            if ( n2%i == 0){
                suma2 += i;
            }
        }

        if (suma1 == n2 && suma2 == n1){

            System.out.println("Los números " + n1 + " y " + n2 + " son amigos");

        } else {
            System.out.println("Los números introducidos no son amigos :(");
        }

    }
    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduzca un número: ");
        int num1 = teclado.nextInt();

        System.out.print("Introduzca otro número: ");
        int num2 = teclado.nextInt();


        if( num1 <= 0 || num2 <= 0 ){
            
            System.out.println("Error: Algún número introducido es negativo o 0");
        } else {

            isPerfectNumber(num1, num2);
        }
        

    

    }
}