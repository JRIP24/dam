package triangle;

public class Triangle1{

    private int side1;
    private int side2;
    private int side3;

    public Triangle1(){

        this.side1 = 3;
        this.side2 = 4;
        this.side3 = 5;

    }

    public Triangle1(int s1, int s2, int s3){

        this.side1 = s1;
        this.side2 = s2;
        this.side3 = s3;
    }


    public int perimetre(){
        return this.side1 + this.side2 + this.side3;
    }

    public double area(){

        double s = (side1 + side2 + side3)/2.0;
        
        return Math.sqrt((s * (s - side1) * (s - side2) * (s -side3)));
    }


    //Getters
    public int getSide1(){

        return this.side1;
    }

    public int getSide2(){
        
        return this.side2;
    }

    public int getSide3(){
        
        return this.side3;
    }

    //Setters

    public void setSide1(int num){
        this.side1 = num;
    }

    public void setSide2(int num){
        this.side2 = num;
    }

    public void setSide3(int num){
        this.side3 = num;
    }
}