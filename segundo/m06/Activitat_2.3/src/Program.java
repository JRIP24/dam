import java.util.Scanner;

public class Program {
	

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		int opcion;
		
		System.out.println("Que desea hacer? \n");
		System.out.println("  1) Almacenar datos de trabajador");
		System.out.println("  2) Recuperar datos de un trabajador \n");

		System.out.print("Introduzca 1 o 2: ");
		
		if (teclado.hasNextInt()) {
			
			switch (teclado.nextInt()) {
			
			case 1:
				System.out.println("Introduzca los datos del trabajador");
				
				System.out.print("NIF: ");
				teclado.nextLine();
				String nif = teclado.nextLine();
				
				System.out.print("Nombre: ");
				String nombre = teclado.nextLine();
				
				System.out.print("sueldo: ");
				
				if (teclado.hasNextInt()) {
					
					int sueldo = teclado.nextInt();
					 
					if (sueldo > 0) {//Todo correcto, continuamos
						
						Treballador trabajador = new Treballador(nif, nombre, sueldo);
						
						trabajador.saveData();
						
					} else {
						
						System.out.println("Error: valor para sueldo incorrecto");
					}
					
					
					
				} else {
					
					System.out.println("Error: valor para sueldo incorrecto");
				}
				
				
				break;
				
			case 2:
				
				System.out.println("Ha escogido la opción 2");
				
				break;

			default:
				System.out.println("ERROR: se debe introducir 1 o 2");
				break;
			}
			
		} else {
			System.out.println("ERROR: no se ha introducido un número");
		}
		
		
	

	}

}
