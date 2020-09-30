import java.util.Scanner;

public class Program{


    public static String screwSize( double size){

        String mensaje;

        if (size >= 1 && size < 3 ){
            
            mensaje = "Petit";

        } else if (size >= 3 && size < 5) {

            mensaje = "Mitjà";

        } else if (size >= 5 && size < 6.5) {

            mensaje = "Gran";

        } else if (size >= 6.5 && size < 8.5) {

            mensaje = "Molt Gran";
        } else {
            mensaje = "Tamño no encontrado";
        }

        return mensaje;

        
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        double tornillo;

        System.out.print("Escriba el tamaño del tornillo en cm: ");
        tornillo = teclado.nextDouble();

        System.out.println(screwSize(tornillo));

    }
}