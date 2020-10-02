package exercici_reforç_de_1r;

import java.time.LocalDateTime;

public class Timoner extends Tripulant{
	
	private	boolean serveiEnElPont;
	private String descripcioFeina;
	
	public Timoner(String id, String nombre, boolean activo, LocalDateTime fechaAlta, int departamento, int llocServei, boolean sirvePuente, String descripcion) {
		
		super(id, nombre, activo, fechaAlta, departamento, llocServei);
		this.serveiEnElPont = sirvePuente;
		this.descripcioFeina = descripcion;
		
		
	}
	
	
	private boolean serveixEnElPont() {
		return this.serveiEnElPont;
	}

}
