import java.util.HashSet;

public class Program {


    public static void main(String[] args){


        Visit v1 = new Visit("24/05/2020-12:30:00", "Ronald");
        Visit v2 = new Visit("24/05/2020-12:40:00", "Lázarp");
        Visit v3 = new Visit("24/05/2020-13:00:00", "Manolo");
        Visit v4 = new Visit("24/05/2020-13:30:00", "Ana");
        Visit v5 = new Visit("24/05/2020-17:00:00", "Pepe");
        Visit v6 = new Visit("24/05/2020-17:15:00", "María");

        Surgery s = new Surgery("Drake", "Odontología");

        s.program(v1);
        s.program(v2);
        s.program(v3);
        s.program(v4);
        s.program(v5);
        s.program(v6);

        System.out.println("_----------------------------------------------------------");
        System.out.println("Visitas programadas: " + s.countVisits());
        System.out.println("Visitas programadas: " + s.countVisits("24/05/2020-12:00:00", "24/05/2020-13:00:00"));
        
    }
}