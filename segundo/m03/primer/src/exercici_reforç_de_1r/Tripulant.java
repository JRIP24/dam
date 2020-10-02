package exercici_reforç_de_1r;

import java.time.LocalDateTime;

public abstract class Tripulant {
	
	protected static String bandol = "Imperi Klingon";
	protected String ID;
	protected String nom;
	protected boolean actiu;
	protected LocalDateTime dataAlta;
	protected int departament;
	private int llocDeServei;
	
	public Tripulant(String id, String nombre, boolean activo, LocalDateTime fechaAlta, int departamento, int llocServei) {
		this.ID = id;
		this.nom = nombre;
		this.actiu = activo;
		this.dataAlta = fechaAlta;
		this.departament = departamento;
		this.llocDeServei = llocServei;
	}
	
	protected int getLlocDeServei() {
		return this.llocDeServei;
	}
	
	protected abstract void ImprimirDadesTripulant();
	
	protected void saludar() {
		System.out.println("Hola des de la superclasse Tripulant");
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tripulant other = (Tripulant) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}
	
	
	
	

}
