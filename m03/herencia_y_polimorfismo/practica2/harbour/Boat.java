public abstract class Boat{

    private String regPlate;
    private double length;
    private int year;


    public Boat(String rP, double len, int y){
        
        this.regPlate = rP;
        this.length = len;
        this.year = y;
    }

    public String getRegPlate(){
        return this.regPlate;
    }

    public int getYear(){
        return this.year;
        
    }

    public double getLength(){
        return this.length;
    }

    public abstract double amountAccordingToBoat();

    public double baseAmount(){
        
    }


}