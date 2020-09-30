import java.util.Scanner;

public class Program{


    public static void divide(int divid, int divis){

        int cosiente = 0;
        int resto = divid;

        while(resto - divis >= 0){
            
            resto = resto - divis;
            
            //Incremento
            cosiente++;
        }


        System.out.println(cosiente + ":" + (+resto));
        
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce el dividendo: ");
        int dividendo = teclado.nextInt();

        System.out.print("Introduce el divisor: ");
        int divisor = teclado.nextInt();

        if (divisor == 0){
            System.out.println("Error: no se puede dvidir por 0");
        } else {

            divide(dividendo, divisor);
        }

        
    }
}