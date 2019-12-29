import java.util.Scanner;

public class ProgramTUI{

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        float num;
        boolean salir = false;
        int cont_md = 0;
        int cont_i = 0;
        int cont_s = 0;
        int cont_b = 0;
        int cont_n = 0;
        int cont_e = 0;

        while(salir == false){

            System.out.print("Introduzca una nota: ");
            num = teclado.nextFloat();

            if (num < 0.0){ //Condicion de salida

                salir = true;

            } else {

                if (num >= 0 && num < 3){
                    cont_md++;
                } else if (num >= 3 && num < 5){
                    cont_i++;
                } else if (num == 5){
                    cont_s++;
                } else if (num == 6){
                    cont_b++;
                } else if (num >= 7 && num < 9){
                    cont_n++;
                } else if (num == 9 || num == 10){
                    cont_e++;
                }
            }
        }

        System.out.println("Número de alumnos con nota Mala/Deficiente: " + cont_md);
        System.out.println("Número de alumnos con nota Insuficiente: " + cont_i);
        System.out.println("Número de alumnos con nota Suficiente: " + cont_s);
        System.out.println("Número de alumnos con nota Buena: " + cont_b);
        System.out.println("Número de alumnos con nota Notable: " + cont_n);
        System.out.println("Número de alumnos con nota Excelente: " + cont_e);
        
    }
}