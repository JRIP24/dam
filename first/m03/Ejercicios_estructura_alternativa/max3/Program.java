import java.util.Scanner;

public class Program{

    static String max3(double n1, double n2, double n3){

        double mayor;
        String mensaje;

        if (n1 >= n2 && n1 >= n3){
            mensaje = "El mayor es " + n1;
        } else if (n2 >= n3){
            mensaje = "El mayor es " + n2;
        } else {
            mensaje = "El mayor es " + n3;
        }
        
        return mensaje;
    }


    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        double numero1;
        double numero2;
        double numero3;

        System.out.print("Introduzca un número: ");
        numero1 = teclado.nextDouble();

        System.out.print("Introduzca otro número: ");
        numero2 = teclado.nextDouble();

        System.out.print("Introduzca otro número: ");
        numero3 = teclado.nextDouble();
    
        System.out.println(max3(numero1, numero2, numero3));
        

    }

}