import java.util.Scanner;

public class Program{


    public static int getNumberOfDays( int m, int y){

        int d;

        if ( m >= 1 && m <= 12 ){

            if ( m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12 ){
                
                d = 31;

            } else if ( m == 2){
                
                if (y%400 == 0 || (y%4 == 0 && y%100 != 0) ){

                    d = 29;

                } else {

                    d = 28;
                }
            } else {

                d = 30;
            }

        } else { //El valor de mes no es válido

            d = 0;
        }


        return d;

        
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        int mes;
        int any;
        int dias;

        System.out.print("Introduzca el mes: ");
        mes = teclado.nextInt();

        System.out.print("Introduzca el año: ");
        any = teclado.nextInt();


        dias = getNumberOfDays(mes, any);

        if (dias == 0){

            System.out.println("Error: el mes introducido es incorrecto");
        } else {
            System.out.println("Número de días: " + dias);
        }


    }
}