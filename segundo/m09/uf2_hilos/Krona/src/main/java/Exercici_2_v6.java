public class Exercici_2_v6 {

    public static void inicialitzarPrograma(){
        SistemaDeGuiaDeTorpedes sistemaDeGuiaDeTorpedes = new SistemaDeGuiaDeTorpedes();
        int numTorpedos = 10;
        Thread[] torpedos = new Thread[numTorpedos];

        sistemaDeGuiaDeTorpedes.imprimirUsDelSistemaDeGuia("Exercici_7.inicialitzarPrograma() - INICI");

        for (int i = 0; i < numTorpedos; i++){

            Torpede torpedeTmp = new Torpede(sistemaDeGuiaDeTorpedes);
            torpedos[i] = new Thread(torpedeTmp);
            torpedos[i].setName("torpede " + i);
            torpedos[i].start();

        }

        try {
            torpedos[numTorpedos - 1].join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sistemaDeGuiaDeTorpedes.imprimirUsDelSistemaDeGuia("Exercici_7.inicialitzarPrograma() - FI");

    }
}
