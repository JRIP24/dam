package ring;


public class Ring{

    String model;
    double ditD;
    double anellD;

    public Ring(String m, double D, double d ){
        this.model = m;
        this.ditD = D;
        this.anellD  = d;
    }

    public double peso(){

        double ditR = this.ditD/2;
        double anellR = this.anellD/2;
        
        //Peso en mm²
        return 2 * Math.pow(Math.PI, 2) * ditR * Math.pow(anellR, 2);
    }



}