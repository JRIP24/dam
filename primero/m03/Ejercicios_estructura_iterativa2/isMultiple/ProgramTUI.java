import java.util.Scanner;

public class ProgramTUI{

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        boolean salir = false;
        boolean hay_multiplo = false;
        int contador = 0;
        int num = 0;

        System.out.print("Introduzca un número entero positivo: ");
        int x = teclado.nextInt();

        System.out.print("Introduzca las veces que se pedirá un número: ");
        int n = teclado.nextInt();

        System.out.println("");//Salto de línea

        if (x < 0){
            salir = true;
        }


        while(salir == false){


            if (contador == n){ //Condicion de salida

                salir = true;

            } else {

                contador++;

                System.out.print("Introduzca un número: ");
                num = teclado.nextInt();

                if ( num%x == 0){
                    salir = true;
                    hay_multiplo = true;
                }

            }
        }

        if (hay_multiplo == true){

            System.out.println("El número " + num + " es múltiplo de " + x);
        }

        
    }
}