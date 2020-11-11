import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Alumne {
	
	private String nom;
	private String dni;
	private boolean repetidor;
	
	
	public Alumne() {
		
	}
	
	public Alumne(String nomP, String dniP, boolean repetidorP) {
		
		this.nom = nomP;
		this.dni = dniP;
		this.repetidor = repetidorP;
		
	}
	
	public void imprimir() {
		
		System.out.println("Nombre: " + this.nom);
		System.out.println("DNI: " + this.dni);
		System.out.println("Repetidor: " + this.repetidor + "\n");
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public boolean isRepetidor() {
		return repetidor;
	}

	public void setRepetidor(boolean repetidor) {
		this.repetidor = repetidor;
	}
	
	
	
public void saveData(Element nodoAlumno, Document doc){
		
		
		Element nodoNombre = doc.createElement("nombre");
		nodoNombre.setTextContent(this.nom);
		
		nodoAlumno.appendChild(nodoNombre);
		
		
		Element nodoDNI = doc.createElement("dni");
		nodoDNI.setTextContent(this.dni);
		
		nodoAlumno.appendChild(nodoDNI);
		
		
		Element nodoRepetidor = doc.createElement("repetidor");
		nodoRepetidor.setTextContent(String.valueOf(this.repetidor));
		
		nodoAlumno.appendChild(nodoRepetidor);
		
		
		
		
		
		
		
	}
	
	
	
	
	
	

}
