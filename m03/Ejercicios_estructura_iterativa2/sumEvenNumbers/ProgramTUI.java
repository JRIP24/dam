import java.util.Scanner;

public class ProgramTUI{

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        float num;
        int par = 0;
        float suma = 0;
        boolean salir = false;

        while(salir == false){

            System.out.print("Introduzca un número positivo: ");
            num = teclado.nextFloat();

            if (num <= 0.0){ //Condicion de salida

                salir = true;

            } else {

                if (num%2.0 == 0.0){
                    par++;
                    suma = suma + num;
                }

            }
        }

        System.out.println("Se han encontrado " + par + " números pares");
        System.out.println("La suma de los número pares encontrados es: " + suma);
        
    }
}