import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;



public class Treballador  implements Serializable{
	
	String archivo = "/home/users/inf/wiam2/iam2671090/dam/segundo/m06/Activitat_2.3/trabajador.txt";	
	private String NIF;
	private String nom;
	private int sou;
	private int edat;
	
	
	public Treballador() {
		
	}
	
	
	public Treballador(String nif, String n, int s){
		this.NIF = nif;
		this.nom = n;
		this.sou = s;
		
	}
	/*
	public Treballador(String nif, String n, int s, int e){
		this.NIF = nif;
		this.nom = n;
		this.sou = s;
		this.edat = e;
		
	}*/

	public void saveData() throws IOException{
		
		
		ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(archivo));
		
		try {
			
			salida.writeObject(this);
			System.out.println("Se han guardado los datos correctamente");
			
			
		} catch (Exception e) {
			
			System.out.println("Error al guardar: " + e);
			
		} finally {
			
			salida.close();
		}
		
		
	}
	
	
	public void readData() throws FileNotFoundException, IOException {
		
		ObjectInputStream entrada = new ObjectInputStream( new FileInputStream(archivo));
		
		try {
			
			Treballador trabajador = (Treballador) entrada.readObject();
			this.NIF = trabajador.NIF;
			this.nom = trabajador.nom;
			this.sou = trabajador.sou;
			
			System.out.println(trabajador.toString());
			
		} catch (Exception e) {
			
			System.out.println("Error al leer: " + e);
			
			
		} finally {
			entrada.close();
		}
		
		
	}
	
	
	//Format binari específc
	public void saveDataBinary() throws IOException {
		
		DataOutputStream salida = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(archivo)));
		
		try {
			
			salida.writeUTF(this.NIF);
			salida.writeUTF(this.nom);
			salida.writeInt(this.sou);
			//salida.writeInt(this.edat);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al guardar los datos: " + e);
			
		} finally {
			salida.close();
		}
		
	}
	
	
	public void readDataBinary() throws IOException {
		
		DataInputStream entrada = new DataInputStream(new BufferedInputStream(new FileInputStream(archivo)));
		
		try {
			
			this.NIF = entrada.readUTF();
			this.nom = entrada.readUTF();
			this.sou = entrada.readInt();
			//this.edat = entrada.readInt();
			
			System.out.println(this.toString());
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Error al leer: " + e);
			
			
		} finally {
			entrada.close();
		}
		
		
	}
	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Treballador [NIF=" + this.NIF + ", nom=" + this.nom + ", sou=" + this.sou + "]";
	}

	/*
	@Override
	public String toString() {
		return "Treballador [NIF=" + this.NIF + ", nom=" + this.nom + ", sou=" + this.sou + ", edad= " + this.edat + "]";
	}*/
	
	
	
	
	
	
}
