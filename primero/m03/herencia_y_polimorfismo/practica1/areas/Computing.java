public class Computing extends Classroom{
    
    private int nPrinters;

    public Computing(String cod, double sA, boolean nL, double con, int cap){
        super(cod, sA, nL, con, cap);
    }

    public int getNPrinters(){
        return this.nPrinters;
    }

    public void setNPrinters(int nP){
        this.nPrinters = nP;
    }

}