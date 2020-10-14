import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class Reader {
	
	
	public int[] leer(String nomFitxer) throws ClassNotFoundException {
		
		int[] estat = null;
		
		try {
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nomFitxer));
			estat = (int[]) entrada.readObject();
			entrada.close();
			
		} catch (IOException ex) {
			System.out.println("Error al leer: " + ex);
			
		} 
		return estat;
	}
	

}
