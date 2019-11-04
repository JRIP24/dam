import java.util.Scanner;

public class Program{

    static String areDivisible(int n1, int n2){

        String mensaje;

        if (n1%n2 == 0 && n2%n1 == 0){
            mensaje = "Los números introducidos son divisibles entre sí";
        } else {
            mensaje = "Los números introducidos no son divisibles entre sí";
        }

        return mensaje;
    }

    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        int num1;
        int num2;

        System.out.print("Introduzca un número: ");
        num1 = teclado.nextInt();

        System.out.print("Introduzca otro número: ");
        num2 = teclado.nextInt();

        System.out.println(areDivisible(num1, num2));





    }


}