import java.util.Scanner;

public class ProgramTUI{

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        float num;
        int par = 0;
        boolean salir = false;

        while(salir == false){

            System.out.print("Introduzca un número positivo: ");
            num = teclado.nextFloat();

            if (num <= 0.0){ //Condiciones de salida

                salir = true;

                if (num < 0){
                    System.out.println("Error: Debe introducir números positivos");
                }

            } else {

                if (num%2 == 0){
                    par++;
                }

            }
        }

        if (par == 1){
            System.out.println("Se ha encontrado " + par + " número par");
        } else {
            System.out.println("Se han encontrado " + par + " números pares");
        }
    }
}