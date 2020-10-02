public class Gym extends Classroom{
    
    private boolean showers;
    private int nStands;

    public Gym(String cod, double sA, boolean nL, double con, int cap){
        super(cod, sA, nL, con, cap);
    }

    public double surfaceAreaStudent(){
        double area = this.getSurfaceArea() + this.nStands;
        return area / this.getCapacity();
    }

    public boolean isShower(){
        return this.showers;
    }

    public void setShowers(boolean sh){
        this.showers = sh;
    }

    public int getNStands(){
        return this.nStands;
    }

    public void setNStands(int nS){
        this.nStands = nS;
    }

}