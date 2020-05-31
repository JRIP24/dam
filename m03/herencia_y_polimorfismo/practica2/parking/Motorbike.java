public class Motorbike extends Vehicle{
    
    public Motorbike(String reg, int p){
        
        super(reg, p);
    }

    public double calculateFee(){
        return this.power * 2;
    }
}