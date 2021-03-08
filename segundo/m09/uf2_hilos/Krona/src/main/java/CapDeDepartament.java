public class CapDeDepartament implements Runnable {
    private Magatzem magatzem;
    int movimentRacions;


    public CapDeDepartament(Magatzem magatzem, int movimentRacions) {
        this.magatzem = magatzem;
        this.movimentRacions = movimentRacions;
    }


    // Lo que s'executa quan executem un Thread (li fem el start()).
    @Override
    public void run() {
        String nomFil = Thread.currentThread().getName();

        System.out.println("    " + nomFil + ".INICI");
        System.out.println("    " + nomFil + ".movimentRacions = "  + movimentRacions);
        System.out.println("    " + nomFil + ".magatzem.comprovarQuantitatRacions() = "  + magatzem.comprovarQuantitatRacions());
        System.out.println("    " + nomFil + ".REALITZO L'OPERACIÓ");

        if (movimentRacions > 0) {
            magatzem.retornarRacions(movimentRacions);
        } else {
            magatzem.agafaRacions(movimentRacions);
        }

        System.out.println("    " + nomFil + ".magatzem.comprovarQuantitatRacions() = "  + magatzem.comprovarQuantitatRacions());
        System.out.println("    " + nomFil + ".FI \n");
    }

}
