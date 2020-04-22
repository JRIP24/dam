import java.util.HashSet;

public class PointTUI {

    public static void main(String[] args){

        final Point p1 = new Point(10, 4);
        final Point p2 = new Point(3, 7);
        final Point p3 = new Point(10, 4);

        final HashSet<Point> points = new HashSet<Point>();
        points.add(p1);
        points.add(p2);
        points.add(p3);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println("-----------------------------------");
        System.out.println(p3.toString());
        System.out.println(points);

        /*
        if (p1.equals(p3)){
            System.out.println("Los puntos p1 y p3 son iguales");
        }*/
    }
}