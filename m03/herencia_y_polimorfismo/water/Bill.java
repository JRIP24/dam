public abstract class Bill{

    private double consuption;
    protected double cleaningUp;
    protected double sewerage;
    protected double cleaningUpDiscount;
    protected double sewerageDiscount;

    public Bill(double cons, double clean, double sew){
        
        this.consuption = cons;
        this.cleaningUp = clean;
        this.sewerage = sew;

    }

    private double consuptionAmount(){
        return this.consuption;
    }

    protected abstract double cleaningUpAmount();

    protected abstract double sewerageAmount();

    public double totalAmount(){
        return this.consuptionAmount() + this.sewerageAmount() + this.cleaningUpAmount();
    }

    public void details(){

    }


}