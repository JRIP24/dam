import java.util.ArrayList;

public class Harbour {
    
    private String city;
    private String country;
    ArrayList<Rent> rents;

    public Harbour(String cit, String coun){
        this.city = cit;
        this.country = coun;
        this.rents = new ArrayList<Rent>();
    }

    public boolean add(Rent r){
        return this.rents.add(r);
    }

    public double calculateAmountMonth(int month, int year){

    }

    public void reportRents(String pathReport){
        
    }




}