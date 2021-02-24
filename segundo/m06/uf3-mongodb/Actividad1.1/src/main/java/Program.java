import java.util.List;

public class Program {

    public static void exercici1() {
        Assignatura a1 = new Assignatura("Accés a dades",5);
        AssignaturaMongo.insereix(a1);
        Assignatura a2 = new Assignatura("Sistemes de gestió empresarial",3);
        AssignaturaMongo.insereix(a2);
    }

    public static void exercici2() {
        List<Assignatura> llistaAssig = AssignaturaMongo.llegeix(0);
        for (Assignatura assig : llistaAssig) {
            System.out.println(assig);
        }
    }

    public static void exercici3() {
        AssignaturaMongo.elimina();
    }

    public static void main(String[] args) {
        //exercici1();
        //exercici2();
        exercici3();
    }


}
