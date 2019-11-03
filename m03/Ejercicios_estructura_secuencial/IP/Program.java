import java.util.Scanner;
import java.util.regex.*;

public class Program{

    static String isIP( String dir_ip){
        String mensaje;
        String patron = "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";
        
        if (dir_ip.matches(patron) == true){

            mensaje = "La IP es válida!";

        } else {
            mensaje = "La IP no es válida";
        }

        return mensaje;
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        String ip;
        String resultado;

        System.out.print("Introduzca una IP (se comprobará validez): ");
        ip = teclado.next();

        resultado = isIP(ip);

        System.out.println(resultado);

    }


}