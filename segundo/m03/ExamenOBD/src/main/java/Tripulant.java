import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tripulant {

    public static void menu10(ObjectContainer db) {

        ArrayList <Tripulant_Dades> llistaTripulants = new ArrayList<Tripulant_Dades>();
        llistaTripulants.add(new Tripulant_Dades(0, "Kurn_0_1", 1));
        llistaTripulants.add(new Tripulant_Dades(3, "Kurn_3_1", 1));
        llistaTripulants.add(new Tripulant_Dades(2, "Kurn_2_2", 2));
        llistaTripulants.add(new Tripulant_Dades(4, "Worf_4_1", 1));
        llistaTripulants.add(new Tripulant_Dades(1, "Kurn_1_1", 1));

        //Hacemos un query para ver si se tiene que hacer UPDATE
        Predicate p = new Predicate<Tripulant_Dades>() {
            @Override
            public boolean match(Tripulant_Dades t) {
                return true;
            }
        };

        List<Tripulant_Dades> result = db.query(p);

        for (final Tripulant_Dades t : llistaTripulants){
            boolean coincide = false;
            for (Tripulant_Dades tripulantResult : result){

                if (tripulantResult.equals(t)){

                    Predicate p2 = new Predicate<Tripulant_Dades>() {
                        @Override
                        public boolean match(Tripulant_Dades p) {
                            return (p.getTripulantId() == t.getTripulantId());
                        }
                    };

                    ObjectSet<Tripulant_Dades> result2 = db.query(p2);
                    if (result2.size() == 1) {
                        Tripulant_Dades tripulantDades = result2.next();


                        System.out.println("UPDATE");
                        System.out.println(tripulantResult);
                        System.out.println("canviat a...");
                        System.out.println(t);
                        db.store(tripulantDades);
                    }
                    coincide = true;
                    //db.store(t);

                }

            }

            if (!coincide){
                System.out.println("INSERT");
                System.out.println(t);
                db.store(t);
            }
/*
            if(result.contains(t)){
                System.out.println("UPDATE");
                System.out.println(t);
                System.out.println("canviat a...");
                System.out.println(t);
            } else {
                System.out.println("INSERT");
                System.out.println(t);
            }*/
        }
    }

    public static void menu11(ObjectContainer db) {

        Predicate p = new Predicate<Tripulant_Dades>() {
            @Override
            public boolean match(Tripulant_Dades t) {
                return true;
            }
        };

        List<Tripulant_Dades> result = db.query(p);

        for (Tripulant_Dades t : result){
            System.out.println(t);
        }
    }

    public static void menu12(ObjectContainer db) {

        Predicate p = new Predicate<Tripulant_Dades>() {
            @Override
            public boolean match(Tripulant_Dades t) {
                return true;
            }
        };

        List<Tripulant_Dades> resultTrip = db.query(p);

        Predicate p2 = new Predicate<Departament_Dades>() {
            @Override
            public boolean match(Departament_Dades d) {
                return true;
            }
        };

        List<Departament_Dades> resultDep = db.query(p2);

        for (Tripulant_Dades tripulant : resultTrip){

            Iterator<Departament_Dades> it = resultDep.iterator();
            while (it.hasNext()) {
                Departament_Dades departament = it.next();
                if (tripulant.getDepartamentId() == departament.getId()){
                    System.out.println("UPDATE");
                    System.out.println(departament);
                    departament.addTripulant(tripulant);
                    System.out.println("canviat a...");
                    System.out.println(departament);
                    db.store(departament);

                }
            }
        }

    }

}
