import java.util.Scanner;

public class Program{


    public static String calculateSolutions(float a, float b, float c){

        String mensaje = "";
        float discriminante = (float)(Math.pow(b, 2) - (4.0 * a * c));
        float sol1;
        float sol2;

        if (discriminante > 0){//Dos soluciones

            sol1 = (float)(-b+(Math.sqrt(discriminante)))/(2*a);
            sol2 = (float)(-b-(Math.sqrt(discriminante)))/(2*a);

            mensaje = "x1 = " + sol1 + ", " + " x2 = " + sol2;

        } else if ( discriminante == 0) {//Una solución
            
            sol1 = (float)(-b+(Math.sqrt(discriminante)))/(2*a);
            mensaje = "x1 = " + sol1 ;

        } else {//Ninguna solución
            
            mensaje = "No té solució";
            
        }
        

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

        System.out.println(calculateSolutions(num1, num2, num3));


    }
}