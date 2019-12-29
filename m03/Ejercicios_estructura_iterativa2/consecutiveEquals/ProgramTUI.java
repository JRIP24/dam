import java.util.Scanner;

public class ProgramTUI{

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        int num;
        int anterior = 0;
        boolean salir = false;

        while(salir == false){

            System.out.print("Introduzca un número positivo: ");
            num = teclado.nextInt();

            if (num == 0){ //Condiciones de salida

                salir = true;

            } else {

                if (num == anterior){
                    salir = true;
                    System.out.println("Se han encontrado dos números consecutivos iguales");
                } else{
                    anterior = num;
                }

            }
        }

        
    }
}