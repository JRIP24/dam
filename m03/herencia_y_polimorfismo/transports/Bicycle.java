public class Bicycle extends Transport {
    
    private int nGears;

    public Bicycle(String identificador, double velocidad){
        super(identificador, velocidad);
    }

    public Bicycle(String identificador, double velocidad, int nG){
        super(identificador, velocidad);
        this.nGears = nG;
    }

    public double cost(double distancia){

        return distancia / this.nGears;
    }

    public int getNGears(){
        return this.nGears;
    }
}