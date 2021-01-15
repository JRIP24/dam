import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MetodesKristall {

	static void menu1() throws IOException {

		File fitxer = new File("a.txt"); // Adreçament relatiu
		File fitxer2 = new File("b.txt");
		FileReader reader1 = null; // Entrada
		FileReader reader2 = null; 
		BufferedReader br; // Buffer
		BufferedReader br2;
		String linea;
		String linea2;
		
		try {
			
			reader1 = new FileReader(fitxer); // Inicialitza entrada del fitxer
			br = new BufferedReader(reader1); // Inicialitza buffer amb l’entrada
			
			reader2 = new FileReader(fitxer2);
			br2 = new BufferedReader(reader2);
			
			int contador = 1;
			int contDiferentes = 0;
			
			linea = br.readLine();
			linea2 = br2.readLine();
			
			while (linea != null || linea2 != null) {
				
				if (!linea.equals(linea2)) {
					
					System.out.println("Falla en la línea: " + contador);
					System.out.println("Linea de " + fitxer.getName() + ": " + linea);
					System.out.println("Linea de " + fitxer2.getName() + ": " + linea2);
					
					contDiferentes++;
					
				}
				
				//Incremento de contador
				contador++;
				linea = br.readLine();
				linea2 = br2.readLine();				
			}
			
			System.out.println("Número de líneas diferentes: " + contDiferentes);
			System.out.println("FIN DE LA COMPARACIÓN.");
			
		} catch (FileNotFoundException e) {
			
			System.out.println("Fitxer no existeix");
			
		} catch (IOException e) {
			
			System.out.println(e.getMessage());
			
		} finally {
			
			if (reader1 != null) {
				reader1.close();				
			}
			
			if (reader2 != null) {
				reader2.close();				
			}
				
		}

	}
	
	
	static void menu2() throws IOException {
		
		File fitxer = new File("a.txt"); // Adreçament relatiu
		File fitxer2 = new File("b.txt");
		
		ArrayList<File> archivos = new ArrayList<File>();
		archivos.add(fitxer);
		archivos.add(fitxer2);
		
		for (File file : archivos) {
			
			String linea;
			FileReader reader = null; // Entrada
			BufferedReader br; // Buffer
			try {
				
				reader = new FileReader(file); // Inicialitza entrada del fitxer
				br = new BufferedReader(reader); // Inicialitza buffer amb l’entrada
				int contadorLin = 0;
				int contadorCar = 0;
				
				linea = br.readLine();
				
				while (linea != null) {
						
					contadorLin++;
					
					contadorCar = contadorCar + (int)linea.chars().count();
					
					linea = br.readLine();				
				}
				
				System.out.println("L'arxiu " + file.getName() + " té " + contadorLin + " linies i " + contadorCar + " caracters.");
				
			} catch (FileNotFoundException e) {
				
				System.out.println("Fitxer no existeix");
				
			} catch (IOException e) {
				
				System.out.println(e.getMessage());
				
			} finally {
				
				if (reader != null) {
					reader.close();				
				}
					
			}
			
		}
		
		
		
	}
	
	
	
	
	
}
