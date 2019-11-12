import java.util.Scanner;

public class Program{

    static String max3(double n1, double n2, double n3){

        double mayor;
        String mensaje;

        if (n1 > n2 && n2 >= n3 || n1 > n2 && n2 < n3){

            mensaje = "El número mayor es " + n1;

        } else if (n2 > n1 && n1 >= n3 || n2 > n1 && n1 < n3){
            
            mensaje = "El número mayor es " + n2;

        } else if (n3 > n1 && n1 >= n2 || n3 > n1 && n1 < n2){
            
            mensaje = "El número mayor es " + n3;
            
        } else if (n1 == n2 && n2 > n3){
            mayor = n1;//igual a 2
            mensaje = "El primer y el segundo número son los mayores: " + mayor;
            
        } else if (n1 == n3 && n3 > n2){
            
            mayor = n1;//igual a 3
            mensaje = "El primer y el tercer número son los mayores: " + mayor;
            
        } else if (n3 == n2 && n2 > n1){
            
            mayor = n3;//igual a 2
            mensaje = "El segundo y el tercer número son los mayores: " + mayor;
            
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

        if (numero1 == numero2 && numero2 == numero3){

            System.out.println("Los números són iguales");

        } else{
            
            System.out.println(max3(numero1, numero2, numero3));
        }

    }

}