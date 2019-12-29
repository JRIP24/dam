import java.util.Scanner;

public class ProgramTUI{

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        float num;
        float suma = 0;
        int contador = 0;
        boolean salir = false;

        while(salir == false){

            System.out.print("Introduzca un número positivo: ");
            num = teclado.nextFloat();

            if (num <= 0.0){ //Condicion de salida

                salir = true;

            } else {

                contador++;
                suma = suma + num;

            }
        }
        System.out.println("La media obtenida de los números introducidos es: " + suma/contador);
        
    }
}