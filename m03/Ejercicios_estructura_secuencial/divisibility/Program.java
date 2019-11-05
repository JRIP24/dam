import java.util.Scanner;

public class Program{

    static boolean areDivisible(int n1, int n2){

        return (n1%n2 == 0 && n2%n1 == 0);
    }

    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        int num1;
        int num2;
        boolean resultado;

        System.out.print("Introduzca un número: ");
        num1 = teclado.nextInt();

        System.out.print("Introduzca otro número: ");
        num2 = teclado.nextInt();

        resultado = areDivisible(num1, num2);

        if (resultado == true){

            System.out.println("Los números introducidos son divisibles entre sí");

        } else{

            System.out.println("Los números introducidos no son divisibles entre sí");
        }







    }


}