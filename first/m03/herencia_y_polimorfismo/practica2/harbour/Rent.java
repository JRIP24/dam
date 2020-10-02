public class Rent {
    
    private String dni;
    private String name;
    private String iniDate;
    private String endDate;
    private String wharfageCode;
    private static final double FIXED_VALUE;

    private Boat boat;

    public Rent(String d, String n, String iDate, String eDate, String wCode){
        
        this.dni = d;
        this.name = n;
        this.iniDate = iDate;
        this.endDate = eDate;
        this.wharfageCode = wCode;
    }

    public void setBoat(Boat b){
        this.boat = b;
    }

    public String getDni(){
        return this.dni;
    }

    public String getName(){
        return this.name;
    }

    public String getWharfageCode(){
        return this.wharfageCode;
    }

    public String getIniDate(){
        return this.iniDate;
    }

    public String getEndDate(){
        return this.endDate;
    }

    public long days(){

    }

    public double amount(){

    }

    public double amountPerDay(){
        
    }


}