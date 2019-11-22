import java.util.Scanner;

public class Program{


    public static String dayPlus1( int d, int m, int y){

        String mensaje;
        boolean error = false;

        //Control de errores
        if (d <= 0 || d > 31 || m <= 0 || m > 12 || y <= 0){

            error = true;

        } else if ( m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12){ //Meses con 31 dias

            if (d == 31){//Cambio de mes

                if ( m == 12){ //Cambio de año

                    d = 1;
                    m = 1;
                    y = y + 1;

                } else {
                    m = m + 1;
                }

                d = 1;
            
            } else {
                d = d + 1;
            }


        } else if ( m == 2) {
            
            if (y%400 == 0 || (y%4 == 0 && y%100 != 0) ){//El año es bisiesto

                if (d > 29){
                    
                    error = true;

                } else if (d == 29){
                    d = 1;
                    m = m + 1;
                } else {
                    d = d + 1;
                }

            } else { //El año no es bisiesto
                
                if (d > 28){
                    
                    error = true;

                } else if (d == 28){
                    d = 1;
                    m = m + 1;
                } else {
                    d = d + 1;
                }
            }

        } else if (d == 30){//Cambio de mes en meses con 30 dias

            d = 1;
            m = m + 1;

        } else  if (d < 30){
            d = d + 1;
        } else {
            error = true;
        }


        mensaje = "El día siguiente es: " + d + "/" + m + "/" + y;

        if (error == true){
            mensaje = "Error: la fecha introducida es incorrecta";
        }

        return mensaje;
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        int dia;
        int mes;
        int any;

        System.out.print("Introduzca un dia: ");
        dia = teclado.nextInt();

        System.out.print("Introduzca un mes: ");
        mes = teclado.nextInt();

        System.out.print("Introduzca un año: ");
        any = teclado.nextInt();

        System.out.println("");//Espacio en blanco

        System.out.println("Fecha introducida: " + dia + "/" + mes + "/" + any);
        System.out.println(dayPlus1(dia, mes, any));


    }
}