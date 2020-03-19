package counter1;


public class Counter1Digit{

    int num;

    public Counter1Digit(){
        this.num = 0;
    }

    public void reset(){
        this.num = 0;
    }

    public void contar(int n){

        for (int i = 0; i < n; i++){
            this.num++;
            System.out.println(this.num);
        }

    }



    public static void main(String[] args){

        Counter1Digit c = new Counter1Digit();
        c.contar(9);
        
    }


}