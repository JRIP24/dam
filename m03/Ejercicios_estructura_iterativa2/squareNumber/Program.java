import java.util.Scanner;

public class Program{

    public static void isSquareNumber(int n){

        boolean salir = false;
        boolean es_cuadrado = false;
        int contador = 0;


        for (int i = 1; i <= n; i++){
            
            if (Math.pow(i, 2) == n){
                contador++;
                es_cuadrado = true;
            }
        }

        if (es_cuadrado == true){

            System.out.println("El número " + n + " es un cuadrado perfecto");

        } else {
            System.out.println("El número introducido no es un cuadrado perfecto");
        }

        
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduzca un número entero: ");
        int num = teclado.nextInt();

        System.out.println("");//Salto de línea

        isSquareNumber(num);

        
    }
}