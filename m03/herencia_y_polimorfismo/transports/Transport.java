public abstract class Transport{

    private String id;
    private double speed;

    public Transport(String identificador, double velocidad){
        this.id = identificador;
        this.speed = velocidad;
    }

    public double time(double distancia){
        return distancia / this.speed;
    }

    public abstract double cost(double distancia);

    public double getSpeed(){
        return this.speed;
    }

    public void setSpeed(double s){
        this.speed = s;
    }

    public String getId(){
        return this.id;
    }
}