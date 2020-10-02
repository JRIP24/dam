import java.util.Scanner;


public class Program{

    static void sumDigits(int n){

        int num_dec = n; 
        int last_number; 
        int suma = 0;
        boolean salir = false;

        while (salir == false){

            last_number = num_dec%10;
            suma = suma + last_number;
            num_dec = num_dec / 10;

            if (num_dec <= 0){

                //Condición de salida
                if (num_dec <= 0){
                    salir = true;

                }
            }            
        }
        
        System.out.println("La suma de los dígitos de " + n + " es: " + suma);
        
    }


    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Introduce un número: ");
        int num = teclado.nextInt();

        sumDigits(num);


    }
}