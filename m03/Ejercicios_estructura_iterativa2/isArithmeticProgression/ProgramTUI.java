import java.util.Scanner;

public class ProgramTUI{

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        int num;
        int anterior;
        int d;//Diferéncia de la progresión artimética
        boolean salir = false;
        boolean es_progresion = false;

        System.out.print("Introduzca un número entero: ");
        anterior = teclado.nextInt();

        System.out.print("Introduzca otro número entero: ");
        num = teclado.nextInt();

        d = num - anterior;


        while(salir == false){

            anterior = num;

            System.out.print("Introduzca otro número entero: ");
            num = teclado.nextInt();

            if (num == 0){ //Condiciones de salida

                salir = true;

            } else {

                if (num - anterior == d){

                    es_progresion = true;

                } else {
                    es_progresion = false;
                }

            }
        }


        if (es_progresion == true){

            System.out.println("La secuencia escrita es una progresión aritmética");

        } else {
            System.out.println("La secuencia escrita no es una progresión aritmética");
        }


        
    }
}