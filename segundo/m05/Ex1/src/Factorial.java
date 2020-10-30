import java.util.Scanner;

public class Factorial {

	public static double factorial (double numero) {

		if (numero==0)
			return 1;
		else
		{
			double resultat = numero * factorial(numero-1);
			return resultat;
		}
	}

	 public static void main(String[] args) {
		 
		 Scanner teclado = new Scanner(System.in);
		 System.out.print("Introduce un numero: ");
		 int numero = teclado.nextInt();

		System.out.println(factorial(5));
	}
}