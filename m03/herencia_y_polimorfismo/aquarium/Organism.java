public abstract class Organism{

    private String name;
    private String family;
    private char light;
    private double maxTemp;
    private double minTemp;
    private double maxPH;
    private double minPH;

    public Organism(String n, String f, char l, double maxT, double minT, double maxP, double minP){
        
        this.name = n;
        this.family = f;
        this.light = l;
        this.maxTemp = maxT;
        this.minTemp = minT;
        this.maxPH = maxP;
        this.minPH = minP;

    }

    public String acidity(){

        return this.minPH  + "-" + this.maxPH;

    }

    public String temperature(){
        return this.minTemp  + "-" + this.maxTemp;
    }

    public String lightType(){

        String resultado;

        switch (this.light) {
            case 'H':

                resultado = "Necesidades altas de luz";
                break;

            case 'M':
                resultado = "Necesidades media de luz";
                break;

            case 'L':
                resultado = "Necesidades bajas de luz";
                break;
        
            default:
                resultado = "Necesidades no especificadas";
                break;
        }

        return resultado;
    }

    public String getName(){
        return this.name;
    }

    public String getFamily(){
        return this.family;
    }

    public char getLight(){
        return this.light;
    }


}