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

        System.out.println("------------------------------");

        Player p1 = new Player(8,9);

        System.out.println("Posición: " + p1.getPosition());
        p1.fall();
        p1.moveRight();
        System.out.println("Posición (después de caer u moverse a la derecha): " + p1.getPosition());

        p1.moveLeft();
        p1.jump();//No es exactamente saltar, ya que al final sel salto volvería a la misma posición
        System.out.println("Posición (después de moverse a la izquierda y saltar): " + p1.getPosition());

    }
}