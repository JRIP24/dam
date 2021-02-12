import java.util.ArrayList;
import java.util.Iterator;

public class Departament_Dades {

    private int id;
    private String nom;
    private String email;
    private String telefon;
    private ArrayList<Tripulant_Dades> tripulants;

    public Departament_Dades(){

    }

    public Departament_Dades(int id, String nom, String email, String telefon, ArrayList<Tripulant_Dades> tripulants) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.telefon = telefon;
        this.tripulants = tripulants;
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

    public ArrayList<Tripulant_Dades> getTripulants() {
        return tripulants;
    }

    public void setTripulants(ArrayList<Tripulant_Dades> tripulants) {
        this.tripulants = tripulants;
    }

    @Override
    public String toString() {
        return "Departament " +  this.nom + " {" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", telefon='" + telefon + '\'' +
                ", tripulants= [" + tripulants +
                "]}";
    }

    public void addTripulant(Tripulant_Dades tripulant) {

        if (this.tripulants.contains(tripulant)){
        boolean actualizado = false;
            Iterator<Tripulant_Dades> it = this.tripulants.iterator();
            while (it.hasNext() || actualizado == false) {
                Tripulant_Dades t = it.next();
                if (t.equals(tripulant)){
                    tripulants.remove(t);
                    tripulants.add(tripulant);
                    actualizado = true;
                }

            }

        } else {
            this.tripulants.add(tripulant);
        }

    }
}
