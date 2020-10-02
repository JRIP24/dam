public class Plant extends Organism{
    
    private char type;

    public Plant(String n, String f, char l, double maxT, double minT, double maxP, double minP){
        super(n, f, l, maxT, minT, maxP, minP);
    }

    public String plantType(){

        String resultado;

        switch (this.type) {
            case 'S':

                resultado = "Tija";
                break;

            case 'B':
                resultado = "Bulb";
                break;

            case 'R':
                resultado = "Raíz";
                break;
        
            default:
                resultado = "Tipo no especificado";
                break;
        }

        return resultado;
    }

    public void setType(char t){
        this.type = t;
    }
}