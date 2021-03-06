package cylinder;


public class Cylinder{

    private double radi;
    private double altura;


    public Cylinder(double r, double a){

        this.radi = r;
        this.altura = a;
    }

    public double area(){

        return 2 * Math.PI * this.radi * ( this.radi + this.altura);

    }

    public double volumen(){

        return Math.PI * Math.pow(this.radi, 2)* this.altura;

    }

    public boolean grater(double v){

        double vol = this.volumen();
        return vol > v;
    }

    public double getRadi(){
        return this.radi;
    }


    public static void main(String[] args){

        System.out.println("------------------------------");

        Cylinder c = new Cylinder(8, 13);

        System.out.println("Área: " + c.area());
        System.out.println("Volumen: " + c.volumen());
        System.out.println("-------------");

        Cylinder c2 = new Cylinder(2, 8);
        System.out.println("Área del segundo cilindro: "  + c2.area());
        System.out.println("Volumen del segundo cilindro: " + c2.volumen());

        System.out.println("El segundo cilindro es mas grande que el primero?: " + c2.grater(c.volumen()));
    }
    
}