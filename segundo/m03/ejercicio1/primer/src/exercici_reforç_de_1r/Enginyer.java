package exercici_reforç_de_1r;

import java.time.LocalDateTime;

public class Enginyer extends Tripulant{
	
	
	private	boolean serveiEnElPont;
	private String descripcioFeina;
	
	public Enginyer(String id, String nombre, boolean activo, LocalDateTime fechaAlta, int departamento, boolean sirvePuente, String descripcion) {
		
		super(id, nombre, activo, fechaAlta, departamento);
		this.serveiEnElPont = sirvePuente;
		this.descripcioFeina = descripcion;
		
		
	}
	
	
	private boolean serveixEnElPont() {
		return this.serveiEnElPont;
	}

}
