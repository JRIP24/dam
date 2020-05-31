public class Car extends Vehicle{
    
    private int nSeats;

    public Car(String reg, int p, int n){
        
        super(reg, p);
        this.nSeats = n;
    }

    public double calculateFee(){
        return this.power * this.nSeats;
    }


}