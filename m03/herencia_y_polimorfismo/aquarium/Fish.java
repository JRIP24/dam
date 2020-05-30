public class Fish extends Organism{
    
    private String origin;
    private char diet;
    private double length;

    public Fish(String n, String f, char l, double maxT, double minT, double maxP, double minP){
        super(n, f, l, maxT, minT, maxP, minP);

    }

    public String dietType(){

        String resultado;

        switch (this.diet) {
            case 'W':

                resultado = "Algas";
                break;

            case 'O':
                resultado = "Omnívora";
                break;

            case 'L':
                resultado = "Hojas";
                break;
        
            default:
                resultado = "Dieta no especificada";
                break;
        }

        return resultado;
    }

    public String getOrigin(){
        return this.origin;
    }

    public void setOrigin(String o){
        this.origin = o;
    }

    public double getLength(){
        return this.length;
    }

    public void setLength(double l){
        this.length = l;
    }

    public void setDiet(char d){
        this.diet = d;
    }

}