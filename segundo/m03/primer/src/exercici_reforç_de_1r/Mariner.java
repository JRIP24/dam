package exercici_reforç_de_1r;

import java.time.LocalDateTime;

public class Mariner extends Tripulant{
	
	private	boolean serveiEnElPont;
	private String descripcioFeina;
	
	public Mariner(String id, String nombre, boolean activo, LocalDateTime fechaAlta, int departamento, int llocServei, boolean sirvePuente, String descripcion) {
		
		super(id, nombre, activo, fechaAlta, departamento, llocServei);
		this.serveiEnElPont = sirvePuente;
		this.descripcioFeina = descripcion;
		
		
	}
	
	
	private String serveixEnElPont() {
		
		if (this.serveiEnElPont) {
			return "Si";
		} else {
			return "No";
		}
	}
	
	protected void ImprimirDadesTripulant() {
		System.out.println("DADES DEL TRIPULANT:");
		System.out.println("\tBandol: " + this.bandol);
		System.out.println("\tID: " + this.ID);
		System.out.println("\tNom: " + this.nom);
		System.out.println("\tActiu: " + this.actiu);
		System.out.println("\tDepartament (de la classe Tripulant): " + this.departament);
		System.out.println("\tDepartament (de la classe IKSRotarranConstants): " + IKSRotarranConstants.DEPARTAMENTS[this.departament]);
		System.out.println("\tLloc de servei (de la classe Tripulant): " + this.getLlocDeServei());
		System.out.println("\tLloc de servei de la classe IKSRotarranConstants): " + IKSRotarranConstants.LLOCS_DE_SERVEI[this.getLlocDeServei()]);
		System.out.println("\tServeix en el pont?: " + this.serveixEnElPont());
		System.out.println("\tDescripción de la feina que fa: " + this.descripcioFeina);
		System.out.println("\tData d'alta: " + this.dataAlta);
	}

}
