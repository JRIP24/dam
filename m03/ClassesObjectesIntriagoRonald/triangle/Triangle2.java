package triangle;

public class Triangle2{

    public static void main(String[] args){

        System.out.println("------------------------------");
        
        Triangle1 tr = new Triangle1();

        System.out.println("Lado 2 del constructor por defecto: " + tr.getSide2());

        Triangle1 tr2 = new Triangle1(6, 9, 12);
        System.out.println("Lado 1: " + tr2.getSide1());
        System.out.println("Perímetro: " + tr2.perimetre());
        System.out.println("Área: " + tr2.area());

    }
}