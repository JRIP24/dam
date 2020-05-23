public class Program {

    public static void main(String[] args){

        Crud c = new Crud("master.dat", "create.dat", "delete.dat", "update.dat", ":");
        /*
        Orden de ejecución de métodos
        c.create();
        c.delete();
        c.update();*/

        c.create();


    }
}