package chronometer;


public class Chronometer {

    private int h;
    private int m;
    private int s;

    public Chronometer() {
        this.h = 0;
        this.m = 0;
        this.s = 0;
    }

    public void reset(){
        this.h = 0;
        this.m = 0;
        this.s = 0;
    }

    public void start() {

        boolean stop = false;

        while (stop == false) {

            if (s >= 59) {
                s = 0;
                m++;
            } else {
                s++;
            }

            if (m >= 60) {
                m = 0;
                h++;
            }

            System.out.println(h + ":" + m + ":" + s);
            
            //Delay
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            //Condición de salida: que se active stop
        }
    }


    public static void main(String[] args){

        Chronometer c = new Chronometer();

        /*
        Se hará un bucle infinito, ya que no se me ocurre 
        una manera de paralo sin interfaz gráfica
        */
        c.start();


    }

}