package submarine_game;


public class Submarine{

    int cordY = 0;
    int cordX = 0;

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