package org.github.ronald.obd;

import java.text.Collator;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;

public class Waypoint_Dades implements Comparable<Waypoint_Dades>{
	
	private int id; //Clau primaria. Es crea automàticament pel sistema i és intocable.
	private String nom;
	private int[] coordenades;
	private boolean actiu; //TRUE si està actiu i es pot fer servir per afegir-lo a
	//alguna ruta.
	private LocalDateTime dataCreacio;
	private LocalDateTime dataAnulacio; //Quan actiu passi a valdre FALSE.
	private LocalDateTime dataModificacio;
	private int tipus;
	
	


	public Waypoint_Dades(int id, String nom, int[] coordenades, boolean actiu, LocalDateTime dataCreacio, LocalDateTime dataAnulacio, LocalDateTime dataModificacio) {
		
		this.id = id;
		this.nom = nom;
		this.coordenades = coordenades;
		this.actiu = actiu;
		this.dataCreacio = dataCreacio;
		this.dataAnulacio = dataAnulacio;
		this.dataModificacio = dataModificacio;
	}
	
public Waypoint_Dades(int id, String nom, int[] coordenades, boolean actiu, LocalDateTime dataCreacio, LocalDateTime dataAnulacio, LocalDateTime dataModificacio, int tipus) {
		
		this.id = id;
		this.nom = nom;
		this.coordenades = coordenades;
		this.actiu = actiu;
		this.dataCreacio = dataCreacio;
		this.dataAnulacio = dataAnulacio;
		this.dataModificacio = dataModificacio;
		this.tipus = tipus;
	}





public LocalDateTime getDataCreacio() {
	return dataCreacio;
}

public void setDataCreacio(LocalDateTime dataCreacio) {
	this.dataCreacio = dataCreacio;
}

public LocalDateTime getDataAnulacio() {
	return dataAnulacio;
}

public void setDataAnulacio(LocalDateTime dataAnulacio) {
	this.dataAnulacio = dataAnulacio;
}

public LocalDateTime getDataModificacio() {
	return dataModificacio;
}

public void setDataModificacio(LocalDateTime dataModificacio) {
	this.dataModificacio = dataModificacio;
}

public int getTipus() {
	return tipus;
}

public void setTipus(int tipus) {
	this.tipus = tipus;
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
	

	public int[] getCoordenades() {
		return coordenades;
	}

	public void setCoordenades(int[] coordenades) {
		this.coordenades = coordenades;
	}
	
	
	@Override
	public int compareTo(Waypoint_Dades waypoint) {
		int result = 0;
		int distanciaM1 = 0;
        int distanciaM2 = 0;

		if (Arrays.equals(this.coordenades, waypoint.coordenades)) {
			
			Collator tertiaryCollator = Collator.getInstance(new Locale("es"));
            tertiaryCollator.setStrength(Collator.TERTIARY);
            result = tertiaryCollator.compare(this.getName(), waypoint.getName());
            
		} else {
			
			distanciaM1 = (int)Math.pow(this.coordenades[0], 2) + (int)Math.pow(this.coordenades[1], 2) + (int)Math.pow(this.coordenades[2], 2);
			distanciaM2 = (int)Math.pow(waypoint.coordenades[0], 2) + (int)Math.pow(waypoint.coordenades[1], 2) + (int)Math.pow(waypoint.coordenades[2], 2);
			
			if (distanciaM1 < distanciaM2){
				
				result = -1;
				
            } else {
            	
                if (distanciaM1 > distanciaM2) {
                	
                	result = 1;
                	
                } else {
                	
                	result = 0;
                }
            }
		}
		
		
		return result;
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
		
		
		int distancia = (int)Math.pow(this.getCoordenades()[0], 2) + (int)Math.pow(this.getCoordenades()[1], 2) + (int)Math.pow(this.getCoordenades()[2], 2);
		
		return "WAYPOINT " + this.id + ": \n" + 
				"nom = " + this.nom + "\n" +
				"coordenades(x, y, z) = (" + this.coordenades[0] + "," + this.coordenades[1] + "," + this.coordenades[2] + ") (distáncia = " + distancia + ") \n" +
				"actiu = " + this.actiu + " \n" +
				"dataCreació = " + dataC + " \n" +
				"dataAnulació = " + dataA + " \n" +
				"dataModificació = " + dataM + " \n";
		
	}


	
	
	

}
