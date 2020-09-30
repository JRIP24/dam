import java.util.Scanner;

public class ProgramTUI{

    public static float add( float n1, float n2){
        
        return n1 + n2;
    }

    public static float subtract( float n1, float n2){
        
        return n1 + n2;
    }

    public static float multiply( float n1, float n2){
        
        return n1 + n2;
    }

    public static float divide( float n1, float n2){
        
        return n1 / n2;
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        float num1, num2;
        String opcion;


        System.out.println(" ______________________________________________");
        System.out.println("|                                              |");
        System.out.println("|                                              |");
        System.out.println("|                 CALCULADORA                  |");
        System.out.println("|                                              |");
        System.out.println("|           Sumar        ---->    +            |");
        System.out.println("|           Restar       ---->    -            |");
        System.out.println("|           MUltiplicar  ---->    *            |");
        System.out.println("|           Dividir      ---->    /            |");
        System.out.println("|                                              |");
        System.out.println("|______________________________________________|");
        System.out.println();//Salto de línea

        System.out.print("Introduce una opción (+, -, * o /): ");
        opcion = teclado.nextLine();

        System.out.println("");//Salto de línea

        switch(opcion){

            case "+":

                System.out.print("Ingrese el primer número: ");
                num1 = teclado.nextFloat();

                System.out.print("Ingrese el segundo número: ");
                num2 = teclado.nextFloat();

                System.out.println("La suma de " + num1 + " + " + num2 + " es: " + add(num1, num2));

            break;

            case "-":

                System.out.print("Ingrese el primer número: ");
                num1 = teclado.nextFloat();

                System.out.print("Ingrese el segundo número: ");
                num2 = teclado.nextFloat();

                System.out.println("La resta de " + num1 + " - " + num2 + " es: " + subtract(num1, num2));

            break;

            case "*":

                System.out.print("Ingrese el primer número: ");
                num1 = teclado.nextFloat();

                System.out.print("Ingrese el segundo número: ");
                num2 = teclado.nextFloat();

                System.out.println("La multiplicación de " + num1 + " * " + num2 + " es: " + multiply(num1, num2));

            break;

            case "/":

                System.out.print("Ingrese el primer número: ");
                num1 = teclado.nextFloat();

                System.out.print("Ingrese el segundo número: ");
                num2 = teclado.nextFloat();

                if ( num2 == 0){

                    System.out.println("Error: No se puede dividir por 0");

                } else {
                    System.out.println("La división de " + num1 + " / " + num2 + " es: " + divide(num1, num2));
                }

            break;

            default:

            System.out.println("Opción no encontrada :(");

            break;
        }


    }
}