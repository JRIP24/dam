import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

import Varies.Cadena;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.query.Predicate;



public class Departament {



    public static void menu1(ObjectContainer db) {
        String email;
        String telefon;

        for (int i = 1; i < IKSRotarranConstants.DEPARTAMENTS.length; i++) {
            email = IKSRotarranConstants.DEPARTAMENTS[i] + "@IKSRotarran.ik";

            telefon = "";
            for (int j = 0; j < 9; j++) {
                telefon = telefon + String.valueOf(i);
            }

            Departament_Dades departament = new Departament_Dades(i, IKSRotarranConstants.DEPARTAMENTS[i], email, telefon, new ArrayList<Tripulant_Dades>());
            db.store(departament);
            System.out.println("CREAT EL DEPARTAMENT " + departament.getNom() + " AMB ID = " + departament.getId());

        }
    }


    public static void menu2(ObjectContainer db) {
        Predicate p = new Predicate<Departament_Dades>() {
            @Override
            public boolean match(Departament_Dades d) {
                return true;
            }
        };

        List<Departament_Dades> result = db.query(p);
        System.out.println("DEPARTAMENTS: ");
        for (Departament_Dades departament_dades : result) {
            System.out.println(departament_dades.getId() + ". " + departament_dades.getNom());
        }
    }


    public static void menu3(ObjectContainer db) {
        ArrayList<Tripulant_Dades> llistaOrdenadaTripulants;
        Departament_Dades departamentSeleccionat = null;
        String opcio;
        boolean existeixenErrors;
        int numDepSeleccionat;


        Predicate p1 = new Predicate<Departament_Dades>() {
            @Override
            public boolean match(Departament_Dades d) {
                return true;
            }
        };

        List<Departament_Dades> result = db.query(p1);

        int i = 0;
        System.out.println("DEPARTAMENTS:");
        for (Departament_Dades departament : result) {
            System.out.println(i +". " + departament.getNom());
            i++;
        }
        System.out.println();

        existeixenErrors = true;
        do {
            existeixenErrors = false;

            Scanner in = new Scanner(System.in);
            System.out.print("Selecciona un departament: ");
            opcio = in.next();

            if (Cadena.stringIsInt(opcio)) {
                numDepSeleccionat = Integer.parseInt(opcio);

                if ((numDepSeleccionat >= 0) && (numDepSeleccionat < result.size() )) {
                    departamentSeleccionat = result.get(numDepSeleccionat);
                } else {
                    System.out.println("ERROR: HAS SELECCIONAT UN DEPARTAMENTO QUE NO EXISTEIX.");
                    System.out.println();
                    existeixenErrors = true;
                }

            } else {
                System.out.println("ERROR: has introduït " + opcio + " com a departament. Els identificadors dels departaments són integers.");
                existeixenErrors = true;
            }
        } while (existeixenErrors);


        final Departament_Dades finalDepartamentSeleccionat = departamentSeleccionat;
        /*
        Predicate p2 = new Predicate<Tripulant_Dades>() {
            @Override
            public boolean match(Tripulant_Dades t) {
                return t.getDepartamentId() == finalDepartamentSeleccionat.getId();
            }
        };
        List<Tripulant_Dades> result2 = db.query(p2);*/
        

        llistaOrdenadaTripulants = finalDepartamentSeleccionat.getTripulants();
        Collections.sort(llistaOrdenadaTripulants);
        
        for (Tripulant_Dades tripulantDades: llistaOrdenadaTripulants){
            System.out.println(tripulantDades);
        }

    }


    public static ObjectContainer menu21(ObjectContainer db) {

        db.close();

        EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
        config.common().objectClass(Departament_Dades.class).cascadeOnDelete(true);
        config.common().objectClass(Tripulant_Dades.class).cascadeOnDelete(true);
        db = Db4oEmbedded.openFile(config, IKSRotarranConstants.pathBD);


        Departament_Dades departamentSeleccionat = null;
        String opcio;
        boolean existeixenErrors;
        int numDepSeleccionat;



        Predicate p1 = new Predicate<Departament_Dades>() {
            @Override
            public boolean match(Departament_Dades d) {
                return true;
            }
        };

        List<Departament_Dades> result = db.query(p1);

        int i = 0;
        System.out.println("DEPARTAMENTS:");
        for (Departament_Dades departament : result) {
            System.out.println(i +". " + departament.getNom());
            i++;
        }
        System.out.println();

        existeixenErrors = true;
        do {
            existeixenErrors = false;

            Scanner in = new Scanner(System.in);
            System.out.print("Selecciona un departament: ");
            opcio = in.next();

            if (Cadena.stringIsInt(opcio)) {
                numDepSeleccionat = Integer.parseInt(opcio);

                if ((numDepSeleccionat >= 0) && (numDepSeleccionat < result.size() )) {
                    departamentSeleccionat = result.get(numDepSeleccionat);
                } else {
                    System.out.println("ERROR: HAS SELECCIONAT UN DEPARTAMENTO QUE NO EXISTEIX.");
                    System.out.println();
                    existeixenErrors = true;
                }

            } else {
                System.out.println("ERROR: has introduït " + opcio + " com a departament. Els identificadors dels departaments són integers.");
                existeixenErrors = true;
            }
        } while (existeixenErrors);


        final Departament_Dades finalDepartamentSeleccionat = departamentSeleccionat;

        //Se hacer otra query
        Predicate p2 = new Predicate<Departament_Dades>() {
            @Override
            public boolean match(Departament_Dades d) {
                return (d.getId() == finalDepartamentSeleccionat.getId());
            }
        };

        ObjectSet<Departament_Dades> result2 = db.query(p2);
        if (result2.size() != 1) {
            System.out.println("No es pot eliminar aquest departament. N'hi ha més d'1 o 0 amb el mateix ID en la BD.");
        } else {
            Departament_Dades d = result2.next();

            System.out.println("ELIMINAT EN CASCADA EL DEPARTAMENT " + d.getNom());
            db.delete(d);
        }

        //db.delete(finalDepartamentSeleccionat);
        //System.out.println("ELIMINAT EN CASCADA EL DEPARTAMENT " +  finalDepartamentSeleccionat.getNom());


        // Retornem la BD sense la capacitat d'esborrar en cascada.
        db.close();
        config = Db4oEmbedded.newConfiguration();
        db = Db4oEmbedded.openFile(config, IKSRotarranConstants.pathBD);

        return db;

    }


}
