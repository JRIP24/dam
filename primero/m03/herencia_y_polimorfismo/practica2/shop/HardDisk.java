package shop;

public class HardDisk extends Product{
    
    private float capacity;

    public HardDisk(String c, String d, int u, float b, float cap){

        super(c, d, u, b);
        this.capacity = cap;
    }

    public float price(){

        float precio = getBasePrice() * this.capacity;
        float descuento = (precio * 10) / 100;
        return precio - descuento;
    }

    public String toString(){

        String resultado = this.getCode() + "\t" + this.getDescription() + "\t\t" + this.getUnits() + "\t" + this.getCapacity() + "\t" + this.price() + "\t\t" + (this.price() * this.getUnits());

        return resultado;
    }

    public float getCapacity(){
        return this.capacity;
    }
    


}