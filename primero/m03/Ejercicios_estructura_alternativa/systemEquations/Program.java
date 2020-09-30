import java.util.Scanner;


public class Program{

    /**
     * Determines whether a linear system has a solution.
     *
     * @param a the first parameter of the first equation.
     * @param b the second parameter of the first equation.
     * @param c the third parameter of the first equation.
     * @param d the first parameter of the second equation.
     * @param e the second parameter of the second equation.
     * @param f the third parameter of the second equation.
     * @return true if the system has a solution, false otherwise.
    */

    public static boolean hasSolution(float a, float b, float c, float d, float e, float f ){

        //calculamos el determinante
        float det = (a * e) - (b * d);

        return (det == 0);//Si es true, no hay solución
    }

    /**
     * Calculates the solution of a linear system.
     *
     * @param a the first parameter of the first equation.
     * @param b the second parameter of the first equation.
     * @param c the third parameter of the first equation.
     * @param d the first parameter of the second equation.
     * @param e the second parameter of the second equation.
     * @param f the third parameter of the second equation.
     * @return "Sistema incompatible" if there is no solution,
     * "x = solx, y = soly", where solx is the value of x and soly the
     * value of y, if there is a solution.
    */

    public static String calculateSolution(float a, float b, float c, float d, float e, float f) {
        
        boolean sol = hasSolution(a, b, c, d, e, f);
        String resultado;


        if (sol == true){//No hay solución

            resultado = "Sistema incompatible";

        } else {//Hay solución
            
            float dx = (c*e) - (b*f);
            float dy = (a*f) - (c*d);
            float ds = (a*e) - (b*d);

            float solx = dx / ds;
            float soly = dy / ds;


            resultado = "x = " + solx + ", " + "y = " + soly;
            
        }

        
        return resultado;
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        float val_a;
        float val_b;
        float val_c;
        float val_d;
        float val_e;
        float val_f;

        System.out.println(" ______________________________________________");
        System.out.println("|                                              |");
        System.out.println("|      Sistema de ecuaciones a resolver:       |");
        System.out.println("|                                              |");
        System.out.println("|                  ax + by = c                 |");
        System.out.println("|                  dx + ey = f                 |");
        System.out.println("|                                              |");
        System.out.println("|______________________________________________|");
        System.out.println();//Salto de línea


        System.out.print("Introduzca el valor de a: ");
        val_a = teclado.nextFloat();

        System.out.print("Introduzca el valor de b: ");
        val_b = teclado.nextFloat();

        System.out.print("Introduzca el valor de c: ");
        val_c = teclado.nextFloat();

        System.out.print("Introduzca el valor de d: ");
        val_d = teclado.nextFloat();

        System.out.print("Introduzca el valor de e: ");
        val_e = teclado.nextFloat();

        System.out.print("Introduzca el valor de f: ");
        val_f = teclado.nextFloat();


        System.out.println(calculateSolution(val_a, val_b, val_c, val_d, val_e, val_f));
        
    }
}