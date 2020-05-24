public class Program {

    public static void main(String[] args){

        Crud c = new Crud("master.dat", "create.dat", "delete.dat", "update.dat", ":");
        
        c.create();
        c.delete();
        c.update();

    }
}