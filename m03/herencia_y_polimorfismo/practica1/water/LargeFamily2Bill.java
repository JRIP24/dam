public class LargeFamily2Bill extends Bill{
    
    public LargeFamily2Bill(double cons, double clean, double sew){
        super(cons, clean, sew);
    }

    protected double cleaningUpAmount(){
        this.cleaningUpDiscount = 75.0;
        double descuento =  (this.cleaningUpDiscount * this.cleaningUp) / 100;

        return this.cleaningUp - descuento;
    }

    protected double sewerageAmount(){
        this.sewerageDiscount = 50.0;
        double descuento =  (this.sewerageDiscount * this.sewerage) / 100;

        return this.sewerage - descuento;
    }

    public void details(){
        
    }
}