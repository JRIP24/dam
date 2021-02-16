import java.util.ArrayList;
import java.util.List;

public class Assignatura {

    String nom;
    int hores_setmana;
    List<Alumne> alumnes;

    public Assignatura () {
    }

    public Assignatura (String nom, int hores_setmana) {
        this.nom = nom;
        this.hores_setmana = hores_setmana;
    }

    public Assignatura (String nom, int hores_setmana, ArrayList<Alumne> alumnes) {
        this.nom = nom;
        this.hores_setmana = hores_setmana;
        this.alumnes = alumnes;
    }

    @Override
    public String toString() {
        String retorna = "* nom: "+this.nom+", hores_setmana: "+this.hores_setmana;
        return retorna;
    }


}
