public class Magatzem {

    int quantitatRacions = 1000;

    public Magatzem(){

    }

    //Se usa synchronized para que solo 1 hilo pueda acceder a la vez
    //En el métdodo siguiente, esto hace que hasta que acabe el sleep el resto de hilos tienen bloqueado el acceso al método

    public synchronized void retornarRacions(int numRacions) {
        if(Thread.currentThread().getId() == Exercici_1.filID){
            try {
                System.out.println("    " + Thread.currentThread().getName() + ".SLEEP");

                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        this.quantitatRacions = this.quantitatRacions + numRacions;
    }
    public synchronized void agafaRacions(int numRacions) {
        this.quantitatRacions = this.quantitatRacions - numRacions;
    }
    public synchronized int comprovarQuantitatRacions() {
        return this.quantitatRacions;
    }

}
