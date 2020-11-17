import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Ruta_Dades {
	private int id;
	private String nom;
	private ArrayList<Integer> waypoints;
	private boolean actiu;
	private LocalDateTime dataCreacio;
	private LocalDateTime dataAnulacio;
	private LocalDateTime dataModificacio;
    
    
	public Ruta_Dades(int id, String nom, ArrayList<Integer> waypoints, boolean actiu, LocalDateTime dataCreacio,
			LocalDateTime dataAnulacio, LocalDateTime dataModificacio) {
		this.id = id;
		this.nom = nom;
		this.waypoints = waypoints;
		this.actiu = actiu;
		this.dataCreacio = dataCreacio;
		this.dataAnulacio = dataAnulacio;
		this.dataModificacio = dataModificacio;
	}
	

	@Override
    public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        
        return "RUTA " + this.id + ":" + 
                "\n   nom = " + this.nom +
                "\n   actiu = " + this.actiu +
                "\n   dataCreacio = " + this.dataCreacio.format(formatter) +
                "\n   dataAnulacio = " + this.dataAnulacio.format(formatter) +
                "\n   dataModificació = " + this.dataModificacio.format(formatter) + 
                "\n   waypoints: = " + this.waypoints ;
    }
    
}
