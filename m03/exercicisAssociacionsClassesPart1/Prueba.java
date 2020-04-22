import java.util.Scanner;

public class Prueba{


    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        String n1;
        String n2;

        System.out.print("Introduzca un nombre: ");
        n1 = teclado.next();

        System.out.print("Introduzca otro nombre: ");
        n2 = teclado.next();


        // ==

        if(n1 == n2){
            System.out.println("Son iguales ==");
        } else {
            System.out.println("Son diferentes ==");
        }

        // equals()
        if(n1.equals(n2)){
            System.out.println("Son iguales equals()");
        }else{
            System.out.println("Son diferentes equals()");
        }

    }
}