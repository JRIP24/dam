public class Office extends Area{
    
    private int nTables;
    private boolean coffeeMachine;


    public Office(){

    }

    public Office(String cod, double sA, boolean nL, double con){
        super(cod, sA, nL, con);
    }

    public int getNTables(){
        return this.nTables;
    }

    public void setNTables(int nT){
        this.nTables = nT;
    }

    public boolean isCoffeeMachine(){
        return this.coffeeMachine;
    }

    public void setCoffeeMachine(boolean cM){
        this.coffeeMachine = cM;
    }





}