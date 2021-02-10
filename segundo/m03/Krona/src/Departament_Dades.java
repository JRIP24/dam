
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Departament_Dades {
	private int id;
	private String nom;
	private String email;
	private String telefon;
	private List<Encarrec_Dades> llistaEncarrecs = new LinkedList<Encarrec_Dades>();
	
	
	public Departament_Dades(int id, String nom, String email, String telefon) {
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.telefon = telefon;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public List<Encarrec_Dades> getLlistaEncarrecs() {
		return llistaEncarrecs;
	}

	public void setLlistaEncarrecs(List<Encarrec_Dades> llistaEncarrecs) {
		this.llistaEncarrecs = llistaEncarrecs;
	}
	
	

	public void afegirEncarrec(Encarrec_Dades encarrerPerAfegir) {
		this.llistaEncarrecs.add(encarrerPerAfegir);
	}
	
	public int numEncarrecs() {
		return this.llistaEncarrecs.size();
	}
	
	
	@Override
    public String toString() {
        String res;
        boolean primeraComanda;
        
        res = nom.toUpperCase() + " (id: " + id + ", email: " + email + ", telèfon: " + telefon + ")\n";
        res = res + "Encàrrecs: " ;
        
        primeraComanda = true;
        Iterator<Encarrec_Dades> it = llistaEncarrecs.iterator();
        while (it.hasNext()) {
            Encarrec_Dades encarrecTmp = it.next();
            
            if (!primeraComanda) {
            	res += "           " + encarrecTmp.toString() + "\n";
            } else {
            	res += encarrecTmp.toString() + "\n";
            	primeraComanda = false;
            }
        }
        return res;
    }
	
	
	public String toStringSencill(Encarrec_Dades encarrecTrobat) {
    	String res;
        
        res = nom.toUpperCase() + " (id: " + id + ", email: " + email + ", telèfon: " + telefon + ")\n";
        res = res + "Encàrrec: " + encarrecTrobat.toString();
        
        return res;
    }
}