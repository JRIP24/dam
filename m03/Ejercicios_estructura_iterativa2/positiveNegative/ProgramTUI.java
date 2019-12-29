import java.util.Scanner;

public class ProgramTUI{

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        float num;
        boolean salir = false;
        int cont_pos = 0;
        int cont_neg = 0;

        while(salir == false){

            System.out.print("Introduzca un número: ");
            num = teclado.nextFloat();

            if (num == 0.0){ //Condicion de salida

                salir = true;

            } else {

                if (num < 0){
                    cont_neg++;
                } else {
                    cont_pos++;
                }

            }
        }

        if (cont_neg == cont_pos){

            System.out.println("Hay la misma cantidad de números positivos y negativos");

        } else if (cont_neg > cont_pos){

            System.out.println("Hay mas números negativos que positivos");

        } else {

            System.out.println("Hay mas números positivos que negativos");
        }

        System.out.println("Números positivos: " + cont_pos);
        System.out.println("Números negativos: " + cont_neg);
        
    }
}