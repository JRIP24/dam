import java.util.Scanner;

public class Program{

    static boolean isLeapYear(int any){

        return (any%400 == 0 || (any%4 == 0 && any%100 != 0));

    }

    public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        int year;
        boolean resultado;

        System.out.print("Indique el año (se determinará si es bisiesto): ");
        year = teclado.nextInt();

        resultado = isLeapYear(year);

        if (resultado == true){

            System.out.println("El año introducido es bisiesto");

        } else {
            
            System.out.println("El año introducido no es bisiesto");
            
        }

    }
}