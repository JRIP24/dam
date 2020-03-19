package game;

public class Player{

    Position pos = new Position();
    String nom;

    public Player(int numX, int numY){
        
        this.pos.setXY(numX, numY);;
    }

    public void moveRight(){
        this.pos.incX();
    }

    public void moveLeft(){
        this.pos.decX();
    }

    public void jump(){
        this.pos.incY();
    }

    public void fall(){
        this.pos.decY();
    }

    public String getPosition(){

        return "(" + this.pos.getX() + ", " + this.pos.getY() + ")" ;
    }


    public static void main(String[] args){

        Player p1 = new Player(8,9);

        System.out.println(p1.getPosition());
        p1.fall();
        p1.moveRight();
        System.out.println(p1.getPosition());

        p1.moveLeft();
        p1.jump();
        System.out.println(p1.getPosition());

    }
}