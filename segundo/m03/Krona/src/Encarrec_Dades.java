
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Encarrec_Dades {
	private int idEncarrec;
	private int idDepartamentQueElDemana;
	private ArrayList<Producte_Dades> llistaProductes = new ArrayList<Producte_Dades>();
	private LocalDateTime data;
    
    
    
    public Encarrec_Dades(int idEncarrec, int idDepartamentQueElDemana, LocalDateTime data) {
		this.idEncarrec = idEncarrec;
		this.idDepartamentQueElDemana = idDepartamentQueElDemana;
		this.data = data;
	}


	public int getIdEncarrec() {
		return idEncarrec;
	}

	public void setIdEncarrec(int idEncarrec) {
		this.idEncarrec = idEncarrec;
	}
	
	public int getIdDepartamentQueElDemana() {
		return idDepartamentQueElDemana;
	}

	public void setIdDepartamentQueElDemana(int idDepartamentQueElDemana) {
		this.idDepartamentQueElDemana = idDepartamentQueElDemana;
	}


	public ArrayList<Producte_Dades> getLlistaProductes() {
		return llistaProductes;
	}

	public void setLlistaProductes(ArrayList<Producte_Dades> llistaProductes) {
		this.llistaProductes = llistaProductes;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
    
	
	public void addProducte(Producte_Dades p) {
		llistaProductes.add(p);
    }


	// PETARA SI ESBORREM EN CASCADA EL DEPARTAMENT Comandament PERQUE S'ESBORRARAN DE LA BD ELS PRODUCTES QUE TINGUI EN ELS SEUS ENCARRECS
	// I PER TANT AL FER EL producteTmp.getProducteNom() PETARÀ PERQUÈ ESTÀ BUSCANT UN PRODUCTE QUE JA NO EXISTEIX (ARA ES NULL).
	@Override
	public String toString() {
		String res = "id " + idEncarrec + ", del departament " + IKSRotarranConstants.DEPARTAMENTS[idDepartamentQueElDemana] + ", productes: ";
		
		Iterator<Producte_Dades> it2 = getLlistaProductes().iterator();
        while (it2.hasNext()) {
        	Producte_Dades producteTmp = it2.next();
        	
        	if (producteTmp != null) {
            	res = res + producteTmp.getProducteNom() + ", ";	
        	} else {
            	res = res + "NO EXISTEIX (null), ";
        	}
        	
        }
        
        //Això es per a treure la última coma.
        res = res.substring(0, res.length() - 2);		
        
        return res;
	}

    
}
