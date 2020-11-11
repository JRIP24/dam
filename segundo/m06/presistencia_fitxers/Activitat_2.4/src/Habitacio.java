import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Habitacio {
	
	double ample;
	double llarg;
	String nom;
	List<Moble> mobles = new ArrayList<>();
	String fileName = "/home/ronald/dam/segundo/m06/Activitat_2.4/Properties.txt";
	File archivo = new File(fileName);	
	
	public void saveData() throws IOException {
			
			DataOutputStream salida = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(archivo)));
			
			try {
				
				salida.writeDouble(this.ample);
				salida.writeDouble(this.llarg);
				salida.writeUTF(this.nom);
				
				int cantidad = this.mobles.size();
				
				if (cantidad > 0) {
					
					salida.writeInt(cantidad);
					for (int i = 0; i < cantidad; i++) {
						
						
						salida.writeDouble(this.mobles.get(i).ample);
						salida.writeDouble(this.mobles.get(i).llarg);
						salida.writeDouble(this.mobles.get(i).color);
						
					}
					
				}
				
				
				
				System.out.println("Datos guardados con éxito");
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error al guardar los datos de la habitación: " + e);
				
			} finally {
				salida.close();
			}
			
	}
	
	
	
	public void readData() throws IOException {
			
		DataInputStream entrada = null;
			
			try {
				
				entrada = new DataInputStream(new BufferedInputStream(new FileInputStream(archivo)));
				
				this.ample = entrada.readDouble();
				this.llarg = entrada.readDouble();
				this.nom = entrada.readUTF();
					
				int cantidad = entrada.readInt();
				
				this.mobles.clear();
				
				if (cantidad > 0) {
					
					for (int i = 0; i < cantidad; i++) {
						
						
						Double anchoM = entrada.readDouble();
						Double largoM = entrada.readDouble();
						int colorM = entrada.readInt();
						
						this.mobles.add(new Moble(anchoM, largoM, colorM));
						
						
					}
				}
				
				
				
				
				
			} catch (FileNotFoundException e) {
				
				archivo.createNewFile();
				this.ample = 10;
				this.llarg = 20;
				this.nom = "Habitación 1";
				this.saveData();
				
				
			} catch (Exception e) {
				
				System.out.println("Error al leer: " + e);
				
				
			} finally {
				
				if (entrada != null) {
			        
			        entrada.close();
			        
			    }
				
			}
		
		
	}
	
	
	public void mostrarMuebles() throws IOException {
		
		this.readData();
		
		int cantidad = this.mobles.size();
		
		if (cantidad > 0) {
			
			for (int i = 0; i < cantidad; i++) {
				
				System.out.println("Mueble nª " + i);
				System.out.println("Ancho: " + this.mobles.get(i).ample + "cm");
				System.out.println("Largo: " + this.mobles.get(i).llarg + "cm");
				System.out.println("Color: " + this.mobles.get(i).color + "\n");
			}
			
		} else {
			
			System.out.println("No se encontraron muebles");
		}
		
		
		
	}



	@Override
	public String toString() {
		return "Habitacio [ample=" + ample + ", llarg=" + llarg + ", nom=" + nom + "]";
	}
	
	
	


}
