public class Underground extends Transport{
    
    private double ticketPrice;

    public Underground(String identificador, double velocidad){
        super(identificador, velocidad);
    }

    public Underground(String identificador, double velocidad, double tP){
        super(identificador, velocidad);
        this.ticketPrice = tP;
    }

    public double cost(double distancia){
        return this.ticketPrice;
    }

    public double getTicketPrice(){
        return this.ticketPrice;
    }

    public void setTicketPrice(double tP){
        this.ticketPrice = tP;
    }


}