package game;

public class Position{

    private int x;
    private int y;

    public Position(){
        this.x = 0;
        this.y = 0;
    }

    public Position(int numX, int numY){
        this.x = numX;
        this.y = numY;
    }


    public void incX(){
        this.x++;
    }

    public void incY(){
        this.y++;
    }

    public void decX(){
        this.x--;
    }

    public void decY(){
        this.y--;
    }


    public void setXY(int numX, int numY){
        this.x = numX;
        this.y = numY;
    }



    //Getters
    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    //Setters
    public void setX(int numX){

        this.x = numX;
    }

    public void setY(int numY){

        this.x = numY;
    }




}