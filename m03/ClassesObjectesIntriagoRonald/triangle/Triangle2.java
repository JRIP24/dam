package triangle;

public class Triangle2{

    public static void main(String[] args){
        
        Triangle1 tr = new Triangle1();

        System.out.println(tr.getSide2());

        Triangle1 tr2 = new Triangle1(6, 9, 12);
        System.out.println(tr2.getSide1());
        System.out.println(tr2.perimetre());
        System.out.println(tr2.area());

    }
}