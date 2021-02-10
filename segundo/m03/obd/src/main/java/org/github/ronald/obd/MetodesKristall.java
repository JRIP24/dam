package org.github.ronald.obd;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map.Entry;

public class MetodesKristall {
	
	
	private static void escriureResultatsAlArxiu(TreeMap<Character, Integer> mapa, int total) throws IOException {
		
        FileWriter writer = null;
        File archivo = new File("menu4_resultat.txt");
        
        try {
    		
        	writer = new FileWriter(archivo);
            
            for (Entry<Character, Integer> data : mapa.entrySet()) {
            	writer.write("Caràcter: " + data.getKey() + 
                		", repeticions: " + data.getValue() + 
                		", percentatge: " + data.getValue() * 100 / total + "% \n");
            }
            
        } catch (Exception e) {
            
        	e.printStackTrace();
        	
        } finally {
        	
        	writer.close();
        }
    }
	
	

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
	
	public static void menu4() {
		
		TreeMap<Character, Integer> mapa = new TreeMap<Character, Integer>();
		String archivo = "a.txt";
        FileReader fileReader = null;
        int numLeido = -1;
        int totalLeido = 0;
        FileWriter fileWriter = null;
        
        
        try {
            fileReader = new FileReader(new File(archivo));
            
            while ((numLeido = fileReader.read()) > 0) {
                if (mapa.containsKey((char) numLeido)) {
                	mapa.put((char) numLeido, mapa.get((char) numLeido) + 1);
                } else {
                	mapa.put((char) numLeido, 1);
                }
                
                totalLeido++;
            }
            
            escriureResultatsAlArxiu(mapa, totalLeido);
        
        } catch (FileNotFoundException e) {
        	
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} finally {
			
            try {
				
            	fileReader.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
        }
	}
	

	
	public static void menu5() {
		
		String link = "http://www.escoladeltreball.org/ca";
		BufferedReader bufferReader = null;
		boolean append = false;
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;
        
        
        try {
            URL url = new URL(link);
            URLConnection conn = url.openConnection();
            
            bufferReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            
            fileWriter = new FileWriter("menu5_links.txt", append);
            printWriter = new PrintWriter(fileWriter, true);

            Pattern p = Pattern.compile("(<a href=\")([^\"]+)(\")");	

            String line = "";
            while ((line = bufferReader.readLine()) != null) {
                Matcher matcher = p.matcher(line);
                while (matcher.find()) {
                	
                    fileWriter.write(matcher.group(2) + "\n");
                    printWriter.println(matcher.group(2));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	try {
        		bufferReader.close();
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        	
        	printWriter.close();
        }
	}
	
	
	public static void menu10() {
		String nomDirectori = "src";
		File directori;
		List<String> llistaContingutDirectori = new ArrayList<String>();

        directori = new File(nomDirectori);
        
        mostrarFitxersIDirectoris(directori, llistaContingutDirectori);
        
        System.out.println("Contingut del directori:");
        for (String dada : llistaContingutDirectori) {
        	System.out.println(dada);	
        }
	}
	
	
	private static void mostrarFitxersIDirectoris(File directori, List<String> llistaContingutDirectori) {
        String pathDirectoriActual;
        String[] contingutDirectoriActual;

        
        pathDirectoriActual = directori.getPath();
        
        contingutDirectoriActual = directori.list();
        
        for (int i = 0; i < contingutDirectoriActual.length; i++) {
            File f = new File(pathDirectoriActual + "/" + contingutDirectoriActual[i]);
            
            if (f.isDirectory()) {
                mostrarFitxersIDirectoris(f, llistaContingutDirectori);
            }
            
            llistaContingutDirectori.add(contingutDirectoriActual[i]);
        }
    }


	
	
	
	
	


	
	
	
	
	
	
	
	
	
	
	
}
