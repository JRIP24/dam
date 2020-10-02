public class NormailClientBill extends Bill{
    
    public NormailClientBill(double cons, double clean, double sew){
        super(cons, clean, sew);
    }

    protected double cleaningUpAmount(){
        return this.cleaningUp;
    }

    protected double sewerageAmount(){
        return this.sewerage;
    }

}