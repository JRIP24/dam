import java.util.Scanner;

public class ProgramTUI{

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        boolean salir = false;
        boolean hay_mayor = false;
        int num = 0;

        System.out.print("Introduzca el primer número entero: ");
        int x = teclado.nextInt();

        System.out.println("");//Salto de línea

        while(salir == false){

            System.out.print("Introduzca otro número: ");
            num = teclado.nextInt();

            if (num == 0){ //Condicion de salida

                salir = true;

            } else {

                if ( num > x){
                    salir = true;
                    hay_mayor = true;
                }

            }
        }

        if (hay_mayor == true){

            System.out.println("El número " + num + " es mayor que " + x);
        }

        
    }
}