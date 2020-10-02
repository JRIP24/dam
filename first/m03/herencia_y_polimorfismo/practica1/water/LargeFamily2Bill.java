public class LargeFamily2Bill extends Bill{
    
    public LargeFamily2Bill(double cons, double clean, double sew){
        super(cons, clean, sew);
    }

    protected double cleaningUpAmount(){
        this.cleaningUpDiscount = 75.0;
        double descuento =  (this.cleaningUpDiscount * this.cleaningUp) / 100;

        if(this.cleaningUp - descuento >= 16.0){
            return 16.0;
        } else {
            return this.cleaningUp - descuento;
        }
    }

    protected double sewerageAmount(){
        this.sewerageDiscount = 50.0;
        double descuento =  (this.sewerageDiscount * this.sewerage) / 100;

        if (
            this.sewerage - descuento >= 16.0){
            return 16.0;
        } else {
            return this.sewerage - descuento;
        }


    }

    public void details(){
        String mensaje = "NOTA: si l'import màxim de sanejament i residuals és superior a 16, s'ha comptabilitzat 16.";
        System.out.println(mensaje);
    }
}