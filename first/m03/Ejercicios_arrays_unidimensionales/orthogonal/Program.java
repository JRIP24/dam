import java.util.Scanner;
import java.util.Arrays;

public class Program{


    static void contraction( float[] n1, float[] n2){

        float suma = 0;
        float mult = 0;


        for(int i = 0; i < n1.length; i++){

            mult = n1[i] * n2[i];

            suma = suma + mult;

        }

        System.out.println(suma);

        if (suma == 0){
            System.out.println("Los vectores son ortogonales");
        } else {
            System.out.println("Los vectores NO son ortogonales");
        }



    }


    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        int medida = 2;
        float[] v1 = new float[medida];
        float[] v2 = new float[medida];

        
        for(int i = 0; i < v1.length; i++){
            System.out.print("Número para el primer vector: ");
            v1[i] = teclado.nextFloat();
        }

        System.out.print("");

        for(int i = 0; i < v2.length; i++){
            System.out.print("Número para el segundo vector: ");
            v2[i] = teclado.nextFloat();
        }

        System.out.print("");

        contraction(v1, v2);



    }
}