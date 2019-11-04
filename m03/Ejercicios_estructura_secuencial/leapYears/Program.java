import java.util.Scanner;

public class Program{
    static String isLeapYear(int any){
        
        String mensaje;

        if (any%400 == 0 || (any%4 == 0 && any%100 != 0)){
            mensaje = "El año introducido es bisiesto";
        } else {
            mensaje = "El año introducido no es bisiesto";
        }

        return mensaje;

    }

    public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        int year;

        System.out.print("Indique el año (se determinará si es bisiesto): ");
        year = teclado.nextInt();

        System.out.println(isLeapYear(year));


    }
}