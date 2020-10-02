import java.util.Scanner;

public class Program{

    public static boolean isTriangle( float a, float b, float c){

        return (a+b > c || a+c > b || c + b > a);
    }

    public static String typeOfTriangle(float a, float b, float c){

        String resultado;
        boolean prueba = isTriangle(a, b, c);

        if (prueba == true){//Es triangulo
            if (a == b && b == c){

                resultado = "El triángulo es Equilátero";

            } else if (a == b || b == c || a == c){

                resultado = "El triángulo es Isósceles";

            } else{
                resultado = "El triángulo es Escaleno";
            }
        } else {
            resultado = "No es un triángulo";
        }

        return resultado;
        
    }


    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        float llarg1, llarg2, llarg3;

        System.out.print("Introduce la medida del primer lado: ");
        llarg1 = teclado.nextFloat();

        System.out.print("Introduce la medida del segundo lado: ");
        llarg2 = teclado.nextFloat();

        System.out.print("Introduce la medida del tercer lado: ");
        llarg3 = teclado.nextFloat();

        System.out.println(typeOfTriangle(llarg1, llarg2, llarg3));

    }
}