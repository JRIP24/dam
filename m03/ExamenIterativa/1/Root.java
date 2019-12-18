//Ronald Intriago
//ronaldintriago52@gmail.com

import java.util.Scanner;


public class Root{

    static void digitalRoot(int n){

        int num_dec = n; //Número descompuesto
        int last_number; //Guardaremos el último dígito del número
        int suma = 0;
        boolean salir = false;//Valirable para determinar si salimos del bucle

        while (salir == false){

            last_number = num_dec%10; //Extraemos el último dígito
            suma = suma + last_number; //Hacemos la suma
            num_dec = num_dec / 10; //Eliminamos el último dígito

            if (num_dec <= 0){

                //Condición de salida
                if (num_dec <= 0 && suma < 10){
                    salir = true;

                } else { //Hacemos otra vuelta con el resultado de la suma
                    num_dec = suma;
                    suma = 0;

                }
            }            

        }

        System.out.println("La raíz digital de " + n + " es: " + suma);
        
    }


    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Introduce un número: ");
        int num = teclado.nextInt();

        digitalRoot(num);


    }
}