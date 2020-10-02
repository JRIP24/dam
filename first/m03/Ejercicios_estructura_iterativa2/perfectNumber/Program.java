import java.util.Scanner;

public class Program{

    public static void isPerfectNumber(int n){

        int suma = 0;
        for(int i = 1; i < n; i++ ){

            if ( n%i == 0){
                suma += i;
            }
        }

        if (suma == n){

            System.out.println("El número " + n + " es un número perfecto");
        
        } else {
            System.out.println("El número " + n + " no es perfecto :(");
        }

    }
    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduzca un número: ");
        int num = teclado.nextInt();


        if( num <= 0){
            
            System.out.println("Error: el número introducido es negativo o 0");
        } else {

            isPerfectNumber(num);
        }
        

    

    }
}