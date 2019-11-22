import java.util.Scanner;

public class Program{


    public static String calculateSolutions(float a, float b, float c){

        String mensaje = "";
        float discriminante = Math.pow(b, 2) - (4 * a * c);
        byte soluciones;

        if (discriminante > 0){//Dos soluciones

            soluciones = 2;

        } else if ( discriminante == 0) {//Una solución
            
            soluciones = 1;

        } else {//Ninguna solución?
            
            soluciones = 0;
        }


        
        
        
        
        
        ///x = (float)(-b+Math.sqrt(Math.pow(b,2)-(4*a*c)))/(2*a);


        mensaje = "El resultado es: " + x;


        return mensaje;

    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        float num1;
        float num2;
        float num3;

        System.out.println(" ________________________________________");
        System.out.println("|                                        |");
        System.out.println("|                                        |");
        System.out.println("|           Ecuación a resolver          |");
        System.out.println("|                                        |");
        System.out.println("|               ax^2+bx+c=0              |");
        System.out.println("|                                        |");
        System.out.println("|________________________________________|");
        
        System.out.println("");//Espacio en blanco
        System.out.println("");//Espacio en blanco
        

        System.out.print("Introduzca el valor de a: ");
        num1 = teclado.nextFloat();

        System.out.print("Introduzca el valor de b: ");
        num2 = teclado.nextFloat();

        System.out.print("Introduzca el valor de c: ");
        num3 = teclado.nextFloat();


    }
}