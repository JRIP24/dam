package ring;


public class Ring{

    private String model;
    private double ditD;
    private double anellD;

    public Ring(String m, double D, double d ){
        this.model = m;
        this.ditD = D;
        this.anellD  = d;
    }

    

    public double peso(){

        double ditR = this.ditD/2;
        double anellR = this.anellD/2;
        
        //Volumen en mm³
        /*
        Para pasar de mm³ a cm³
        se divide el valor de volumen entre 1000
        */

        double v = 2 * Math.pow(Math.PI, 2) * ditR * Math.pow(anellR, 2);

        v = v/1000;//Ahora lo tenemos en cm³

        //Se tiene en cuenta que todo el anillo está hecho de oro
        return 19.3 * v;

    }

    public double preuOr(){

        return 10 * this.peso();
    }

    public double precio(){

        double p = 40 + preuOr();
        return p + (p * 2.1);

    }

    public String getModel(){
        return this.model;
    }


    public static void main(String[] args){

        System.out.println("------------------------------");

        Ring anillo = new Ring("MD3", 8, 3);
        System.out.print("Modelo del anillo: " + anillo.getModel() + "\n");

        System.out.printf("Peso: %.2f gr.%n",anillo.peso());
        System.out.printf("Precio del oro: %.2f€%n", anillo.preuOr());
        System.out.printf("Precio del anillo: %.2f€%n", anillo.precio());
    }



}