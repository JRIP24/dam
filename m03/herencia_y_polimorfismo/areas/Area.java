public abstract class Area{

    private String code;
    private double surfaceArea;
    private boolean naturalLight;
    private double consuption;

    public Area(){

    }

    public Area(String cod, double sA, boolean nL, double con){

        this.code = cod;
        this.surfaceArea = sA;
        this.naturalLight = nL;
        this.consuption = con;

    }

    public double consuptionM2(){

    }

    public String getCode(){
        return this.code;
    }

    public double getSurfaceArea(){
        return this.surfaceArea;
    }

    public boolean getNaturalLight(){
        return this.naturalLight;
    }

    public double getConsuption(){
        return this.consuption;
    }
}