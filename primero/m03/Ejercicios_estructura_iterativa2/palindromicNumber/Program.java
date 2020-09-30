import java.util.Scanner;

public class Program{


    public static void isPalindromic(int n){

        int numero_invertido = 0;
        int resto = 0;
        int falta = n;
        
        while (falta > 0){

            resto = falta%10; //Extraemos el último valor
            falta = falta / 10;//Quitamos el último dígito
            numero_invertido = numero_invertido*10+resto;//Reagrupamos los números
            
        }

        if (numero_invertido == n){

            System.out.println("El número " + n + " es capicúa");
        } else {
            System.out.println("El número " + n + " no es capicúa :(");
        }
        
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce un número: ");
        int num = teclado.nextInt();

        isPalindromic(num);
        
    }
}