import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Waypoint_Dades {
	
	private int id; //Clau primaria. Es crea automàticament pel sistema i és intocable.
	private String nom;
	private int[] coordenades;
	private boolean actiu; //TRUE si està actiu i es pot fer servir per afegir-lo a
	//alguna ruta.
	private LocalDateTime dataCreacio;
	private LocalDateTime dataAnulacio; //Quan actiu passi a valdre FALSE.
	private LocalDateTime dataModificacio;
	
	
	public Waypoint_Dades(int id, String nom, int[] coordenades, boolean actiu, LocalDateTime dataCreacio, LocalDateTime dataAnulacio, LocalDateTime dataModificacio) {
		
		this.id = id;
		this.nom = nom;
		this.coordenades = coordenades;
		this.actiu = actiu;
		this.dataCreacio = dataCreacio;
		this.dataAnulacio = dataAnulacio;
		this.dataModificacio = dataModificacio;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.nom;
	}

	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String n) {
		this.nom = n;
	}

	@Override
	public String toString() {
		
		String dataC = "NULL";
		String dataA = "NULL";
		String dataM = "NULL";
		
		
		if (this.dataCreacio != null) {
			
			dataC = this.dataCreacio + "";
			
		}
		
		if (this.dataAnulacio != null) {
			dataA = this.dataAnulacio + "";
		}
		
		if(this.dataModificacio != null) {
			dataM = this.dataModificacio + "";
		}
		
		
		
		
		
		return "WAYPOINT " + this.id + ": \n" + 
				"nom = " + this.nom + "\n" +
				"coordenades(x, y, z) = (" + this.coordenades[0] + "," + this.coordenades[1] + "," + this.coordenades[2] + ") \n" +
				"actiu = " + this.actiu + " \n" +
				"dataCreació = " + dataC + " \n" +
				"dataAnulació = " + dataA + " \n" +
				"dataModificació = " + dataM + " \n";
		
	}


	
	
	

}
