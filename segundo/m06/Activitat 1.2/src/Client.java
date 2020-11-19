
public class Client {
	
	private String nom;
	private int dni;
	private boolean premium;
	
	
	public Client() {
		
	}	
	
	public Client(String nom, int dni, boolean premium) {
		this.nom = nom;
		this.dni = dni;
		this.premium = premium;
	}
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public boolean isPremium() {
		return premium;
	}
	public void setPremium(boolean premium) {
		this.premium = premium;
	}
	
	
	

}
