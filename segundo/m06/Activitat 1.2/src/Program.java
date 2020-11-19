import java.awt.Menu;
import java.util.Scanner;


public class Program {
	
	public static void pausar(){
		
		Scanner scanner = new Scanner(System.in);
	    boolean exit = false;
	    
	    while(!exit) {
	    	
	    	System.out.println("Presione 'Enter' para continuar");
		    String readString = scanner.nextLine();

	        if (readString.isEmpty()) {
	        	System.out.println("\n \n");
	        	
	            exit = true;
	            
	        }
	    }
		
	}
	
	
	static int menu() {
		
		System.out.println("Opciones: \n" +
				"0.- Salir \n" +
				"1.- Creació del model \n" +
				"2.- Recuperació de les dades de la BBDD \n" +
				"3.- Emmagatzemat de dades a la BBDD \n" +
				"4.- Alta d'un nou client \n" +
				"5.- Alta d'una nova comanda \n\n\n");
		System.out.print("Introduzca una opción: ");
		
		
		return 0;
		
	}
	
	public static void main(String[] ags) {
		
		Scanner teclado = new Scanner(System.in);
		boolean salir = false;
		
		while (!salir) {
			
			System.out.println("Opciones: \n" +
					"0.- Salir \n" +
					"1.- Creació del model \n" +
					"2.- Recuperació de les dades de la BBDD \n" +
					"3.- Emmagatzemat de dades a la BBDD \n" +
					"4.- Alta d'un nou client \n" +
					"5.- Alta d'una nova comanda \n\n\n");
				System.out.print("Introduzca una opción: ");
				
				if (teclado.hasNextInt()) {
					
					int opcion = teclado.nextInt();
					
					switch (opcion) {
					
					case 0:
						
						System.out.println("Opcion 0");
						System.out.println("Saliendo...");
						salir = true;
						break;
					
					case 1:
						
						System.out.println("Opcion 1");
						
						pausar();
						break;
						
					case 2:
						
						System.out.println("Opcion 2");
						
						pausar();
						break;
					case 3:
						
						System.out.println("Opcion 3");
						
						pausar();
						break;
					case 4:
						
						System.out.println("Opcion 4");
						
						pausar();
						break;
					case 5:
						
						System.out.println("Opcion 5");
						
						pausar();
						break;

					default:
						System.out.println("Error: el múmero introducido no es una opción");
						pausar();
						break;
					}
					
				} else {
					
					System.out.println("Error: no se ha introducido un número");
					pausar();
				}
				
			
		}
		
		
	}

}
