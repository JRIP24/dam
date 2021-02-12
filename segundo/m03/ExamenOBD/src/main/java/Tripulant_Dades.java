
import java.text.Collator;
import java.util.Locale;
import java.util.Objects;

public class Tripulant_Dades implements Comparable<Tripulant_Dades>{

    private int tripulantId;
    private String tripulantNom;
    private int departamentId;

    public Tripulant_Dades(){

    }

    public Tripulant_Dades(int tripulantId, String tripulantNom, int departamentId) {
        this.tripulantId = tripulantId;
        this.tripulantNom = tripulantNom;
        this.departamentId = departamentId;
    }

    public int getTripulantId() {
        return tripulantId;
    }

    public void setTripulantId(int tripulantId) {
        this.tripulantId = tripulantId;
    }

    public String getTripulantNom() {
        return tripulantNom;
    }

    public void setTripulantNom(String tripulantNom) {
        this.tripulantNom = tripulantNom;
    }

    public int getDepartamentId() {
        return departamentId;
    }

    public void setDepartamentId(int departamentId) {
        this.departamentId = departamentId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tripulant_Dades)) return false;
        Tripulant_Dades that = (Tripulant_Dades) o;
        return tripulantId == that.tripulantId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tripulantId);
    }

    @Override
    public String toString() {
        return "Tripulant_Dades[" +
                "Id=" + tripulantId +
                ", Nom=" + tripulantNom  +
                ", departament Id=" + departamentId +
                ']';
    }

    @Override
    public int compareTo(Tripulant_Dades o) {
        Collator comparador = Collator.getInstance(new Locale("es"));
        comparador.setStrength(Collator.PRIMARY);

        if (this.getDepartamentId() == o.getDepartamentId()){

            return comparador.compare(this.getTripulantNom(), o.getTripulantNom());

        } else {
            return comparador.compare(this.getDepartamentId(), o.getDepartamentId());

        }




    }


}
