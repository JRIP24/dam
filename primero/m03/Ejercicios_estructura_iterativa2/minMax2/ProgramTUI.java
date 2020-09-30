import java.util.Scanner;

public class ProgramTUI{

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        float num;
        boolean salir = false;

        System.out.print("Introduzca un número: ");
        num = teclado.nextFloat();
        float max = num;
        float min = num;
        

        while(salir == false){

            System.out.print("Introduzca otro número: ");
            num = teclado.nextFloat();

            if (num == 0.0){ //Condicion de salida

                salir = true;

            } else {

                if (num < min){
                    min = num;
                }

                if (num > max){
                    max = num;
                }
    
            }
        }

        System.out.println("El número más grande es: " + max);
        System.out.println("El número más pequeño es: " + min);
        
    }
}