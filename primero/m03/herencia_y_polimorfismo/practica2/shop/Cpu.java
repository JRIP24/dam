package shop;

public class Cpu extends Product{
    
    private float speed;

    public Cpu(String c, String d, int u, float b, float s){
        
        super(c, d, u, b);
        this.speed = s;
    }

    public float price(){
        
        return this.getBasePrice() * this.speed;

    }

    public String toString(){

        String resultado = this.getCode() + "\t" + this.getDescription() + "\t\t" + this.getUnits() + "\t" + this.getSpeed() + "\t" + this.price() + "\t\t" + (this.price() * this.getUnits());
        
        return resultado;
    }

    public float getSpeed(){
        return this.speed;
    }


}