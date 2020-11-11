import java.util.Date;

public class Politic {
	
	
	private String nif;
	private String nom;
	private Date dataNaixement;
	private int sou;
	private boolean esCorrupte;
	
	
	/*
	taula -> BBDD
	atribut -> BBDD y POO
	columna-> BBD
	classe -> POO
	objecte -> POO
	*/
	
	
	
	public Politic(String nif, String nom, Date dataNaixement, int sou, boolean esCorrupte) {
		super();
		this.nif = nif;
		this.nom = nom;
		this.dataNaixement = dataNaixement;
		this.sou = sou;
		this.esCorrupte = esCorrupte;
	}	
	
	
	public String getNif() {
		return nif;
	}
	
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Date getDataNaixement() {
		return dataNaixement;
	}
	public void setDataNaixement(Date dataNaixement) {
		this.dataNaixement = dataNaixement;
	}
	public int getSou() {
		return sou;
	}
	public void setSou(int sou) {
		this.sou = sou;
	}
	public boolean isEsCorrupte() {
		return esCorrupte;
	}
	public void setEsCorrupte(boolean esCorrupte) {
		this.esCorrupte = esCorrupte;
	}
	
	
	
	

}
