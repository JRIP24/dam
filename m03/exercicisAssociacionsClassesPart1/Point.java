
public class Point {
    
    private int x;
    private int y;

    public Point(int cx, int cy){

        this.x = cx;
        this.y = cy;

    }


    public void setX(int sx){

        this.x = sx;
    }

    public void setY(int sy){

        this.y = sy;
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

    @Override //Reescribimos un método
    public String toString(){
        return "Point = {" + super.toString() + ", x = " + this.x + ", y = " + this.y + "}\n";
    }

    @Override
    public boolean equals(final Object object){
        if(this == object){
            return true;
        }
        if(!(object instanceof Point)){
            return false;
        }

        final Point punt = (Point)object;
        return (this.x == punt.x) && (this.y == punt.y);
    }

    @Override
    public int hashCode(){
        return x * 31 + y;
    }

}