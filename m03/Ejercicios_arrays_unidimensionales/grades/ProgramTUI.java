import java.util.Scanner;
import java.util.Arrays;

public class ProgramTUI{


    public static void main(String[] args ){

        Scanner teclado = new Scanner(System.in);
        float[] notas = new float[10+1];
        float n;

        for (int i = 1; i < notas.length; i++){

            System.out.print("Introduzca un número: ");
            n = teclado.nextFloat();

            notas[i] = n;
        }

        int cont_in = 0;
        int cont_ap = 0;
        int cont_be = 0;
        int cont_no = 0;
        int cont_ex = 0;

        for (int i = 1; i < notas.length; i++){

            if (notas[i] >= 0.0 && notas[i] < 5.0){
                cont_in++;
            }

            if (notas[i] >= 5.0 && notas[i] < 6.0){
                cont_ap++;
            }

            if (notas[i] >= 6.0 && notas[i] < 7.0){
                cont_be++;
            }

            if (notas[i] >= 7.0 && notas[i] < 9.0){
                cont_no++;
            }

            if (notas[i] >= 9.0 && notas[i] <= 10.0){
                cont_ex++;
            }
            
        }

        float[] alum_in = new float[cont_in];
        float[] alum_ap = new float[cont_ap];
        float[] alum_be = new float[cont_be];
        float[] alum_no = new float[cont_no];
        float[] alum_ex = new float[cont_ex];

        cont_in = 0;
        cont_ap = 0;
        cont_be = 0;
        cont_no = 0;
        cont_ex = 0;


        for (int i = 1; i < notas.length; i++){

            if (notas[i] >= 0.0 && notas[i] < 5.0){
                alum_in[cont_in] = i;
                cont_in++;
            }

            if (notas[i] >= 5.0 && notas[i] < 6.0){
                alum_ap[cont_ap] = i;
                cont_ap++;
            }

            if (notas[i] >= 6.0 && notas[i] < 7.0){
                alum_be[cont_be] = i;
                cont_be++;
            }

            if (notas[i] >= 7.0 && notas[i] < 9.0){
                alum_no[cont_no] = i;
                cont_no++;
            }

            if (notas[i] >= 9.0 && notas[i] <= 10.0){
                alum_ex[cont_ex] = i;
                cont_ex++;
            }
            
        }

        System.out.println("Código de alumnos con nota insuficiente: ");
        System.out.println(Arrays.toString(alum_in));

        System.out.println("Código de alumnos con nota aprobada: ");
        System.out.println(Arrays.toString(alum_ap));

        System.out.println("Código de alumnos con nota buena: ");
        System.out.println(Arrays.toString(alum_be));

        System.out.println("Código de alumnos con nota notable: ");
        System.out.println(Arrays.toString(alum_no));

        System.out.println("Código de alumnos con nota excelente: ");
        System.out.println(Arrays.toString(alum_ex));



    }
}