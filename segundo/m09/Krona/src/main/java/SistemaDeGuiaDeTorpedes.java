import java.util.concurrent.Semaphore;

public class SistemaDeGuiaDeTorpedes {

    private int numDeTorpedesQuePotGuiarSimultaneament;
    private boolean[] usDelSistemaDeGuia;
    private Semaphore maxNumSlots;
    private Semaphore permiso;

    public SistemaDeGuiaDeTorpedes(){
        this.numDeTorpedesQuePotGuiarSimultaneament = 3;
        this.usDelSistemaDeGuia = new boolean[this.numDeTorpedesQuePotGuiarSimultaneament];//Ya son false por defecto

        this.maxNumSlots = new Semaphore(this.numDeTorpedesQuePotGuiarSimultaneament);//Solo 3 torpedos simultaneamente
        this.permiso = new Semaphore(1);

    }

    public int adquirirSistemaDeGuia(String nomThread){

        try {
            maxNumSlots.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return assignarSistemaDeGuia(nomThread);

    }

    synchronized int assignarSistemaDeGuia(String nomThread){

        try {
            permiso.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int indice = 0;
        boolean salir = false;
        boolean slotAsigned = false;

        while (salir == false){

            if (this.usDelSistemaDeGuia[indice] == false){
                this.usDelSistemaDeGuia[indice] = true;
                slotAsigned = true;
            }

            indice++;

            if (indice >= this.usDelSistemaDeGuia.length || slotAsigned){
                salir = true;
                if (slotAsigned){
                    indice--;
                }
            }
        }

        System.out.println(nomThread + ", slotAsignado: " + indice);
        imprimirUsDelSistemaDeGuia(nomThread);

        permiso.release();

        return indice;
    }

    void imprimirUsDelSistemaDeGuia(String nomThread) {

        String mensaje = nomThread + ", usDelSistemaDeGuia = [";
        for(int i = 0; i < this.usDelSistemaDeGuia.length; i++){
            if ( i == this.usDelSistemaDeGuia.length - 1){//Comprobamos si es último para no poner la ,
                mensaje = mensaje + this.usDelSistemaDeGuia[i];
            } else {
                mensaje = mensaje + this.usDelSistemaDeGuia[i] +", ";
            }

        }
        mensaje = mensaje + "]";

        System.out.println(mensaje);

    }

    void alliberarSistemaDeGuia(int numUsDelSistemaDeGuia, String nomThread){
        try {
            permiso.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.usDelSistemaDeGuia[numUsDelSistemaDeGuia] = false;
        imprimirUsDelSistemaDeGuia(nomThread);

        permiso.release();
        maxNumSlots.release();


    }

}
