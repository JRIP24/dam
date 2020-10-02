package circle;

public class Circle{

    private double radi;

    public Circle(double r){
        this.radi = r;
    }

    public double area(){
        return Math.PI * Math.pow(radi, 2);
    }

    public double perimetre(){
        return 2 * Math.PI * radi;
    }

    public boolean grater(double r){
        return this.radi > r;
    }


    public double getRadi(){
        return this.radi;
    }


    public static void main(String[] args){

        System.out.println("------------------------------");
        Circle c = new Circle(6);
        System.out.println("Radio del círculo: " + c.getRadi());
        System.out.println("Perímetro: " + c.perimetre());
        System.out.println("Área: " + c.area());

        Circle c2 = new Circle(2);

        System.out.println("Es más grande que un círculo de " + c2.getRadi() + " de radio?: " + c.grater(c2.getRadi()));


    }

    



}