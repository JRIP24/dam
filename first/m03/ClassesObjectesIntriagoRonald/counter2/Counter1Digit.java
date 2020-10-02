package counter2;


public class Counter1Digit{

    private int num;

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

}