import java.io.File;

import org.apache.commons.io.FileUtils;

public class Exercici1 {

	public static void main(String[] args) {
		
		File origen = null;
		String pathOrigen = "fitxers_examen_2019_2020"; 
		String path = null;
		File directoriArrel = null;
		
		try {
			
			File patata = new File("patata");
			
	        origen = new File(pathOrigen);
	        
	        /*if (FileUtils.directoryContains(origen, patata)) {
	        	
	        	System.out.println("contiene");
				
			}*/
	        
	        //System.out.println(FileUtils.directoryContains(origen, patata));
	        path = "directoriMenu20/";
	        directoriArrel = new File(path);
			FileUtils.forceMkdir(directoriArrel);
			
			
		} catch (Exception e) {
			
			e.getMessage();
			
		} finally {
			
		}

	}

}
