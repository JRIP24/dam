import java.util.Scanner;

public class ProgramTUI{

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        boolean salir = false;
        int suma = 0;
        int num;

        System.out.print("Introduzca un número entero positivo: ");
        int n = teclado.nextInt();

        System.out.println("");//Salto de línea

        for(int i = 1; i <= n; i++){

            System.out.print("Introduzca otro número entero positivo: ");
            num = teclado.nextInt();

            for (int x = 0; x < num; x++){
                suma = suma + n;
            }

            System.out.println("El producto de " + num + " y " + n + " es: " + suma);

            //Reiniciamos la suma
            suma = 0;

        }
        
    }
}