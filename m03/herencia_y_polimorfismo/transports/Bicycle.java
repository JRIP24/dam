public class Bicycle extends Transport {
    
    private int nGears;

    public Bicycle(String identificador, double velocidad){
        super(identificador, velocidad);
    }

    public Bicycle(String identificador, double velocidad, int nG){
        super(identificador, velocidad);
        this.nGears = nG;
    }

    //Se cobrará 5€ por horas
    public double cost(double distancia){
        
        double precio = 5.0;
        return this.time(distancia) * precio;
    }

    public int getNGears(){
        return this.nGears;
    }
}