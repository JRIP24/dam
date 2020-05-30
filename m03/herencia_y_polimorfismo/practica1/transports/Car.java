public class Car extends Transport{
    
    private String fuelType;
    private double literPrice;
    private double litersKm;

    public Car(String identificador, double velocidad){
        super(identificador, velocidad);
    }

    public Car(String identificador, double velocidad, String fType, double lP, double lKm){
        super(identificador, velocidad);
        this.fuelType = fType;
        this.literPrice = lP;
        this.litersKm = lKm;
    }

    public double cost(double distancia){

        return distancia * this.literPrice;
    }

    public double getLiterPrice(){
        return this.literPrice;
    }
    public String getFuelType(){
        return this.fuelType;
    }
    public double getLitersKm(){
        return this.litersKm;
    }


    
}