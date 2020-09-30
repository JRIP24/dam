package counter2;


public class Counter2Digit{

    private int num;

    public Counter2Digit(){
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

        System.out.println("------------------------------");

        Counter1Digit c = new Counter1Digit();
        c.contar(9);//Cuenta hasta 9

        Counter2Digit c2 = new Counter2Digit();
        c2.contar(20);//Hasta 20 (2 dígitos)


        
    }


}