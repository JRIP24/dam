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

                System.out.print("Ingrese el primer número");
                num1 = teclado.nextFloat();

                System.out.print("Ingrese el segundo número");
                num2 = teclado.nextFloat();

            break;

            case "-":

                System.out.print("Ingrese el primer número");
                num1 = teclado.nextFloat();

                System.out.print("Ingrese el segundo número");
                num2 = teclado.nextFloat();

            break;

            case "*":

                System.out.print("Ingrese el primer número");
                num1 = teclado.nextFloat();

                System.out.print("Ingrese el segundo número");
                num2 = teclado.nextFloat();

            break;

            case "/":

                System.out.print("Ingrese el primer número");
                num1 = teclado.nextFloat();

                System.out.print("Ingrese el segundo número");
                num2 = teclado.nextFloat();

            break;

            default:

            System.out.print("Opción no encontrada :(");

            break;
        }


    }
}