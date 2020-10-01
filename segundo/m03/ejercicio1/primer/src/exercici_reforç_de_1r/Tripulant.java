package exercici_reforç_de_1r;

import java.time.LocalDateTime;

public abstract class Tripulant {
	
	static String bandol = "Imperi Klingon";
	String ID;
	String nom;
	boolean actiu;
	LocalDateTime dataAlta;
	int departament;
	private int llocDeServei;
	
	public Tripulant(String id, String nombre, boolean activo, LocalDateTime fechaAlta, int departamento) {
		this.ID = id;
		this.nom = nombre;
		this.actiu = activo;
		this.dataAlta = fechaAlta;
		this.departament = departamento;
	}
	
	protected abstract void ImprimirDadesTripulant();
	
	

}
