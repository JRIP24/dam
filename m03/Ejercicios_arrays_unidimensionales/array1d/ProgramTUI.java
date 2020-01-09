import java.util.Arrays;
import java.util.Scanner;

public class ProgramTUI{

    public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        boolean salir = false;
        float num;

        while(salir == false){


            System.out.print("Introduzca un número: ");
            num = teclado.nextFloat();

            //Condición de salida
            if (num == 0){
                salir = true;
            }
        }
    }
}