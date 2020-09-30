public class Laboratory extends Classroom{
    
    private int nBunsen;

    public Laboratory(String cod, double sA, boolean nL, double con, int cap){
        super(cod, sA, nL, con, cap);
    }

    public int getnBunsen(){
        return this.nBunsen;
    }

    public void setnBunsen(int nB){
        this.nBunsen = nB;
    }


}