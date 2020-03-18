package submarine_game;


public class Submarine{

    private int cordX = 0;
    private int cordY = 0;
    

    int[] aroundX = {getCordX() - 1, getCordX(), getCordX() + 1, getCordX() - 1, getCordX() - 1, getCordX(), getCordX() + 1, getCordX() + 1};
    int[] aroundY = {getCordY() + 1, getCordY() + 1, getCordY() + 1, getCordY(), getCordY() - 1, getCordY() - 1, getCordY() - 1, getCordY()};


    public int getCordX (){
        return this.cordX;
    }

    public int getCordY (){
        return this.cordY;
    }

    public void setCordX (int x){
        this.cordX = x;
    }

    public void setCordY (int y){
        this.cordY = y;
    }



    public void move(int size){

        boolean exit = false;
        int moveTo = 0;

        while(exit == false){

            boolean error = false;
            
            moveTo = (int)Math.floor(Math.random()*(4-1+1)+1);

            switch(moveTo) {

                case 1: //move up

                    if (this.cordY + 1 > size){
                        error = true;
                    }

                break;

                case 2: //move right

                    if (this.cordX + 1 > size){
                        error = true;
                    }

                break;

                case 3: // move down

                    if (this.cordY - 1 < 0){
                        error = true;
                    }

                break;

                case 4: // move left

                    if (this.cordX - 1 < 0){
                        error = true;
                    }

                break;
                
                default:
                    error = true;
            }

            if(error == false){

                exit = true;
            }
            
        }//loop end

        switch(moveTo) {

            case 1: //move up

                moveUp();

            break;

            case 2: //move right

                moveRight();

            break;

            case 3: // move down

                moveDown();

            break;

            case 4: // move left

                moveLeft();

            break;
            
            default:
                this.cordX = this.cordX;
                this.cordY = this.cordY;
        }

    }


    public void moveRight(){
        this.cordX = this.cordX + 1;
    }

    public void moveLeft(){
        this.cordX = this.cordX - 1;
    }

    public void moveUp(){
        this.cordY = this.cordY + 1;
    }

    public void moveDown(){
        this.cordY = this.cordY - 1;
    }

}