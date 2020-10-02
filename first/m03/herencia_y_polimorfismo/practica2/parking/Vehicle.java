package parking;

public abstract class Vehicle{

    private String regPlate;
    protected int power;

    public Vehicle(String reg, int p){
        
        this.regPlate = reg;
        this.power = p;
    }

    public abstract double calculateFee();
    
    public String getRegPlate(){

        return this.regPlate;
    }
}