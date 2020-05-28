public class Classroom extends Area{
    
    private int capacity;
    private boolean chairTable;
    private int nComputers;
    private boolean networkConn;

    public Classroom(String cod, double sA, boolean nL, double con, int cap){
        super(cod, sA, nL, con);
        this.capacity = cap;
    }

    public double surfaceAreaStudent(){
        return this.capacity / this.getSurfaceArea();
    }

    public boolean isTableChair(){
        return this.chairTable;
    }

    public void setTableChair(boolean cT){
        this.chairTable = cT;
    }

    public boolean isNetworkConn(){
        return this.networkConn;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public int getNComputers(){
        return this.nComputers;
    }

    public void setCapacity(int cap){
        this.capacity = cap;
    }

    public void setNComputers(int nC){
        this.nComputers = nC;
    }




}