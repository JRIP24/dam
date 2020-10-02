package exercici_reforç_de_1r;

import java.time.LocalDateTime;

public class Oficial extends Tripulant{
	
	private	boolean serveiEnElPont;
	private String descripcioFeina;
	
	public Oficial(String id, String nombre, boolean activo, LocalDateTime fechaAlta, int departamento, boolean sirvePuente, String descripcion) {
		
		super(id, nombre, activo, fechaAlta, departamento);
		this.serveiEnElPont = sirvePuente;
		this.descripcioFeina = descripcion;
		
		
	}
	
	
	private boolean serveixEnElPont() {
		return this.serveiEnElPont;
	}
	
	public String getDescripcioFeina() {
		return this.descripcioFeina;
	}
	
	protected void ImprimirDadesTripulant() {
		System.out.println("ID: " + this.ID);
		System.out.println("Nom: " + this.nom);
		System.out.println("Actiu: " + this.actiu);
		System.out.println("DataAlta: " + this.dataAlta);
		System.out.println("Departament: " + this.departament);
		System.out.println("Serveix en el pont?: " + this.serveixEnElPont());
		System.out.println("Descripción de la feina: " + this.descripcioFeina);
	}
	
	
}
