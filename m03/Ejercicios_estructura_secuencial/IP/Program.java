import java.util.Scanner;

public class Program{

    static boolean isIP( int ip_1, int ip_2, int ip_3, int ip_4 ){

        return ((ip_1 >=0 && ip_1 <= 255) && (ip_2 >=0 && ip_2 <= 255) && (ip_3 >=0 && ip_3 <= 255) && (ip_4 >=0 && ip_4 <= 255));
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        int ip1;
        int ip2;
        int ip3;
        int ip4;
        boolean resultado;

        System.out.print("Introduzca el primer número de la IP: ");
        ip1 = teclado.nextInt();

        System.out.print("Introduzca el segundo número de la IP: ");
        ip2 = teclado.nextInt();

        System.out.print("Introduzca el tercer número de la IP: ");
        ip3 = teclado.nextInt();

        System.out.print("Introduzca el último número de la IP: ");
        ip4 = teclado.nextInt();

        resultado = isIP(ip1, ip2, ip3, ip4);

        if (resultado == true){

            System.out.println("La IP es válida");

        } else {
            System.out.println("La IP es inválida");
        }

    }


}