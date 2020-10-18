import java.io.ObjectInputStream;

import javax.sound.midi.SysexMessage;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Reader {
	
	
	public void leer(String nomFitxer) throws ClassNotFoundException, FileNotFoundException, IOException {
		
		//ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nomFitxer));
		DataInputStream entrada = new DataInputStream(new BufferedInputStream(new FileInputStream(nomFitxer)));
		int[] array = null;
		
		try {
			
			int cantidad = entrada.readInt();
					
			array = new int[cantidad];
			
			for (int i = 0; i < cantidad; i++) {
				
				array[i] = entrada.readInt();
				System.out.println(array[i]);
			}
			
		} catch (IOException ex) {
			
			System.out.println("Error al leer: " + ex);
			
		} finally {
			
			entrada.close();
		}
		
		
	}
	

}
