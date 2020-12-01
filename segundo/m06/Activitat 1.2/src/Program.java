import java.awt.Menu;
import java.sql.SQLException;
import java.sql.Statement;
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
	
	
	public static void addClient() {
		
		boolean salir = false;
		boolean premium = false;
		Scanner teclado = new Scanner(System.in);
		
		
		while (!salir) {
			
			System.out.print("Introduzca el DNI (sin letra): ");
			if (teclado.hasNextInt()) {
				
				int dni = teclado.nextInt();
				System.out.print("Introduzca el nombre: ");
				String nombre = teclado.nextLine();
				
				System.out.print("Es cliente premium? (1 para si y 0 para no):");
		    	
		    	if (teclado.hasNextInt() ) {
					
		    		int opcion = teclado.nextInt();
		    		
		    		if (opcion == 0 || opcion == 1) {
		    			
						if (opcion == 1) {
							premium = true;
						}
						
						salir = true;
						Client cliente = new Client(nombre, dni, premium);
					
		    		} else {
						System.out.println("Error: No se ha introducido 0 o 1");
					}
		    					    		
				} else {
					System.out.println("Error, no se ha introducido un número");
				}
				
				
				
			} else {
				System.out.println("Error: el DNI introducido no es correcto");
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
	
	public static void main(String[] ags) throws SQLException {
		
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
						MyBBDD driver = new MyBBDD();
						
						try {
							
							String sentenciaSQL = "CREATE TABLE client ("
							+ "dni INT(8) PRIMARY KEY,"
							+ "nom VARCHAR(20),"
							+ "premium BOOLEAN"
							+ "); ";
						
						Statement statement = driver.con.createStatement();
						statement.execute(sentenciaSQL);
						
						sentenciaSQL = "CREATE TABLE comanda ("
								+ "num_comanda INT PRIMARY KEY,"
								+ "preu_total DOUBLE(40, 2),"
								+ "data DATE,"
								+ "dni_client INT(8),"
								+ "FOREIGN KEY (dni_client) REFERENCES client(dni)"
								+ ");";
						
							
						} catch (Exception e) {
							
							System.out.println("Error: " + e);
							
							
						} finally {
							driver.close();							
						}
						
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
