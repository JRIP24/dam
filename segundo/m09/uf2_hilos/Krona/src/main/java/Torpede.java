public class Torpede implements Runnable{

    private SistemaDeGuiaDeTorpedes sistemaDeGuiaDeTorpedes;

    public Torpede(SistemaDeGuiaDeTorpedes sistema) {
        this.sistemaDeGuiaDeTorpedes = sistema;
    }

    @Override
    public void run() {
        int numUsDelSistemaDeGuia;


        System.out.println(Thread.currentThread().getName() + ".INICI");
        numUsDelSistemaDeGuia = sistemaDeGuiaDeTorpedes.adquirirSistemaDeGuia(Thread.currentThread().getName());

        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sistemaDeGuiaDeTorpedes.alliberarSistemaDeGuia(numUsDelSistemaDeGuia, Thread.currentThread().getName() + ".FI");
    }


}
