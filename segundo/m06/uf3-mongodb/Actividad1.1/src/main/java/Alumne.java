
public class Alumne {

    private String dni;
    private String nom;

    public Alumne(){

    }

    public Alumne(String dni, String nom) {
        this.dni = dni;
        this.nom = nom;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Alumne{" +
                "dni='" + dni + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }
}
