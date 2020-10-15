import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Reader {
	
	
	public int[] leer(String nomFitxer) throws ClassNotFoundException, FileNotFoundException, IOException {
		
		ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nomFitxer));
		int[] estat = null;
		
		try {
			
			estat = (int[]) entrada.readObject();
			
			
		} catch (IOException ex) {
			System.out.println("Error al leer: " + ex);
			
		} finally {
			entrada.close();
		}
		
		return estat;
	}
	

}
