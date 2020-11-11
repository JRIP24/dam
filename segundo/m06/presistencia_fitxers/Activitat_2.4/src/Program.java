import java.io.IOException;
import java.util.Scanner;

public class Program {
	
	
	public static void main(String[] args) throws IOException{
		
		Scanner teclado = new Scanner(System.in);
		boolean salir = false;
		
		Habitacio habitacion = new Habitacio();
		habitacion.readData();
		
		
		while (!salir) {
			
			System.out.println("\n\n-------------------\n");
			
			System.out.println("OPCIONES: ");
			System.out.println("0 - Salir ");
			System.out.println("1 - Mostrar datos de la habitación ");
			System.out.println("2 - Añadir un mueble a la habitación ");
			System.out.println("3 - Guardar en disco la habitación ");
			System.out.println("4 - Listar todos los muebles de la habitación \n");
			System.out.print("Elije una opción: ");
			
			
			
			if (teclado.hasNextInt()) {
				
				switch (teclado.nextInt()) {
				
				case 0:
					
					System.out.println("Se ha cerrado el programa con éxito");
					
					salir = true;
					
					break;
					
				case 1:
					
					System.out.println(habitacion.toString());
					
					
					break;
					
				case 2:
					
					System.out.print("Introduza el ancho del mueble (cm): ");
					if (teclado.hasNextDouble()) {
						
						double anchoM = teclado.nextDouble();
						
						
						System.out.print("Introduzca el largo del mueble (cm): ");
						
						if (teclado.hasNextDouble()) {
							
							double largoM = teclado.nextDouble();
							
							System.out.print("Introduzca el color del mueble ");
							
							if (teclado.hasNextInt()) {
								
								int colorM = teclado.nextInt();
								
								Moble mueble = new Moble(anchoM, largoM, colorM);
								
								if (habitacion.mobles.add(mueble)) {
									
									System.out.println("Mueble añadido con éxtio");
									habitacion.saveData();
									
								} else {
									
									System.out.println("Ha ocurrido un error al guardar el mueble :(");
								}
								
							} else {
								
								System.out.println("Error: Dato introducido no válido");

							}
							
							
						} else {
							
							System.out.println("Error: Dato introducido no válido");
						}
						
						
						
						
						
						
					} else {
						System.out.println("Error: Dato introducido no válido");
					}
					
					break;
					
				case 3:
					
					habitacion.saveData();
					
					break;
					
				case 4:
					
					habitacion.mostrarMuebles();
					
					break;
					
					
				default:
					
					System.out.println("Error: debe introducir 0, 1, 2, 3 o 4");
					break;
				}
				
				
			} else {
				
				System.out.println("Error: no se ha introducido ningún número");
				salir = true;
				
			}
			
		}
		
		
		
		
	}

}
