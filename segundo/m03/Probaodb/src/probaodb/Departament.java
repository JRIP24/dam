
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.query.Predicate;


import Varies.Cadena;



public class Departament {
	// static: per aconseguir que la dada afectada sigui comuna a tots els objectes creats d'una mateixa classe.
	// Variable que farem servir per a passar un valor a un predicate per així poder filtrar la búsqueda en la BD.
	private static Producte_Dades producteSeleccionat = null;
	
	
	// menu 3: Crea els departaments, a partir dels que hi ha en IKSRotarranConstants.DEPARTAMENTS, i els fica en la BD.
	public static void menu3(ObjectContainer db) {
		Departament_Dades departament;
		String email;
		String telefon;
		
		
		// La 1a posició de IKSRotarranConstants.DEPARTAMENTS[] no té res. 
		for (int i = 1; i < IKSRotarranConstants.DEPARTAMENTS.length; i++) {
			email = IKSRotarranConstants.DEPARTAMENTS[i] + "@IKSRotarran.ik";
			
			telefon = "";
			for (int j = 0; j < 9; j++) {
				telefon = telefon + String.valueOf(i);	
			}
			
			departament = new Departament_Dades(i, IKSRotarranConstants.DEPARTAMENTS[i], email, telefon);
			
			db.store(departament);
		}
	}
	
	
	// menu 4: Assigna els encàrrecs als departaments i els productes als encàrrecs
	public static void menu4(ObjectContainer db) {
		// 1r de tot hem d'assignar els objectes Encarrec_Dades als objectes Departament_Dades (ficar-los en llistaEncarrecs).
		Predicate p = new Predicate<Departament_Dades>() { 
	        @Override 
	        public boolean match(Departament_Dades d) { 
	            return true;
	        } 
	    }; 
	    
	    ObjectSet<Departament_Dades> result = db.query(p); 
	    
	    while (result.hasNext()) { 
	    	Departament_Dades departamentTmp = result.next(); 
	        
	    	// Busquem per a cada departament els encàrrecs que té i els hi assignem.
	    	Predicate p2 = new Predicate<Encarrec_Dades>() { 
		        @Override 
		        public boolean match(Encarrec_Dades e) { 
		            return (e.getIdDepartamentQueElDemana() == departamentTmp.getId()); 
		        } 
		    }; 
		    
		    ObjectSet<Encarrec_Dades> result2 = db.query(p2); 
		    
		    while (result2.hasNext()) { 
		    	Encarrec_Dades encarrecTmp = result2.next();
		    	
		    	departamentTmp.afegirEncarrec(encarrecTmp);
		    }
		    
	        db.store(departamentTmp);
	    } 
	    
		// Busquem tots els productes.
	    // Rastrejem els productes --> tenim el idDepartamentQueElPotDemanar --> assignem el producte a tots els encàrrecs 
	 	// del departament amb id == idDepartamentQueElPotDemanar.
		Predicate p3 = new Predicate<Producte_Dades>() { 
            @Override 
            public boolean match(Producte_Dades p) { 
                return true; 
            } 
        }; 
        
        List<Producte_Dades> result3 = db.query(p3); 
        
        for (Producte_Dades producteTmp : result3) { 
        	// Busquem per a cada producte el departament que el pot demanar.
        	Predicate p4 = new Predicate<Departament_Dades>() { 
    	        @Override 
    	        public boolean match(Departament_Dades d) { 
    	            if ((d.getId() == producteTmp.getIdDepartamentQueElPotDemanar()) || (producteTmp.getIdDepartamentQueElPotDemanar() == 0)){
    	            	return true;
    	            } else {
    	            	return false;
    	            }
    	        } 
    	    }; 
    	    
    	    ObjectSet<Departament_Dades> result4 = db.query(p4); 
    	    
    	    while (result4.hasNext()) { 
    	    	Departament_Dades departamentTmp = result4.next(); 
    	    	
    	    	Iterator<Encarrec_Dades> it = departamentTmp.getLlistaEncarrecs().iterator();
    	    	
    	    	while (it.hasNext()) {
    	    		Encarrec_Dades encarrecTmp = it.next();
    	    		
    	    		encarrecTmp.addProducte(producteTmp);
    	    		db.store(encarrecTmp);
    	    	}
    	    } 
        } 
	}
	
	
	
	// menu 12: Veure tots els departaments que hi ha en la BD
	public static void menu12(ObjectContainer db) {
		Predicate p = new Predicate<Departament_Dades>() { 
	        @Override 
	        public boolean match(Departament_Dades d) { 
	            return true; 
	        } 
	    }; 
	    
	    ObjectSet<Departament_Dades> result = db.query(p); 
	    
	    System.out.println("DEPARTAMENTS:");
	    while (result.hasNext()) { 
	    	Departament_Dades departamentTmp = result.next(); 
	        System.out.println(departamentTmp.getId() + ". " + departamentTmp.getNom()); 
	    } 
	}
	
	
	
	
	// menu 13: Veure totes les dades de tots els departaments que hi ha en la BD
	public static void menu13(ObjectContainer db) {
		Predicate p = new Predicate<Departament_Dades>() { 
	        @Override 
	        public boolean match(Departament_Dades d) { 
	            return true; 
	        } 
	    }; 
	    
	    ObjectSet<Departament_Dades> result = db.query(p); 
	    
	    while (result.hasNext()) { 
	    	Departament_Dades departamentTmp = result.next(); 
	        System.out.println(departamentTmp);
	        System.out.println();
	    } 
	}
	
	
	
	// menu 14: Veure els departaments que han comprat 1 producte concret.
	// LListar els productes que hi ha en la BD, seleccionar 1 i a llavors veure quins departaments el tenen en quins encàrrecs.
	public static void menu14(ObjectContainer db) {
		ArrayList<Producte_Dades> llistaOrdenadaProductes;
		String opcio;
		boolean existeixenErrors;
		int numProducteSeleccionat;

		
		// LListem tots els productes que hi ha en la BD i fem que l'usuari seleccioni 1.
		Predicate p1 = new Predicate<Producte_Dades>() { 
            @Override 
            public boolean match(Producte_Dades producte) { 
                return true; 
            } 
        }; 
        
        List<Producte_Dades> result = db.query(p1); 
        
        llistaOrdenadaProductes = new ArrayList<Producte_Dades>();
        llistaOrdenadaProductes.addAll(result);
        // Ordenenem alfabéticament els productes. Fa servir el compareTo() que hi ha en Producte_Dades.
        Collections.sort(llistaOrdenadaProductes);

        int i = 0;
        System.out.println("LLista de productes:");
        for (Producte_Dades producteTmp : llistaOrdenadaProductes) {
            System.out.println(i +": " + producteTmp.getProducteNom() + " (" + producteTmp.getProductePreu() + " darseks)");
            i++;
        } 
        System.out.println();
		
        existeixenErrors = true;
		do {
			existeixenErrors = false;

			Scanner in = new Scanner(System.in); 
	        System.out.print("Selecciona un producte: ");
	        opcio = in.next();
			
			if (Cadena.stringIsInt(opcio)) {
				numProducteSeleccionat = Integer.parseInt(opcio);

				if ((numProducteSeleccionat >= 0) && (numProducteSeleccionat < result.size())) {
					producteSeleccionat = llistaOrdenadaProductes.get(numProducteSeleccionat);
				} else {
					System.out.println("ERROR: HAS SELECCIONAT UN PRODUCTE QUE NO EXISTEIX.");
					System.out.println();
					existeixenErrors = true;
				}
				
			} else {
				System.out.println("ERROR: has introduït " + opcio + " com a producte. Els identificadors dels productes són integers.");
				existeixenErrors = true;
			}
		} while (existeixenErrors); 
        
		
		// Busquem tots els encàrrecs que tenen el producte seleccionat.
		Predicate p2 = new Predicate<Encarrec_Dades>() { 
            @Override 
            public boolean match(Encarrec_Dades encarrec) { 
                return encarrec.getLlistaProductes().contains(producteSeleccionat); 
            } 
        }; 
		
        List<Encarrec_Dades> result2 = db.query(p2);
        System.out.println();
        System.out.println("Trobat " + result2.size() + " encàrrecs amb el producte \"" + producteSeleccionat.getProducteNom() + "\".");

        for (Encarrec_Dades encarrecTmp : result2) {
        	System.out.println();
        	
        	// Busquem tots els departaments que tenen els encàrrecs trobats.
        	Predicate p3 = new Predicate<Departament_Dades>() { 
                @Override 
                public boolean match(Departament_Dades d) { 
                    return d.getLlistaEncarrecs().contains(encarrecTmp); 
                } 
            }; 
    		
            ObjectSet<Departament_Dades> result3 = db.query(p3);
            
            if (result3.size() == 0) {
            	System.out.println("ERROR: NO S'HA TROBAT CAP DEPARTAMENT QUE TINGUI ASSIGNAT L'ENCÀRREC AMB ID " + encarrecTmp.getIdEncarrec());
            } else {
	            for (Departament_Dades departamentTmp : result3) {
	            	System.out.println(departamentTmp.toStringSencill(encarrecTmp));
	            }
            }
        } 
		
	}
	
	
	
	// menu 40: Esborrat del departament d'Enginyeria
	// Fem un esborrat del departament d'Enginyeria a veure si s'esborra la seva llista d'encàrrecs automàticament i quins dels
	// productes, que té assignats als seus encàrrecs, s'esborren  automàticament de la base de dades.
	public static void menu40(ObjectContainer db) {
		int departamentAEsborrar;
		
		
		departamentAEsborrar = 4;	
		
		Predicate p = new Predicate<Departament_Dades>() { 
            @Override 
            public boolean match(Departament_Dades d) { 
                return (d.getId() == departamentAEsborrar);
            } 
        }; 
        
        ObjectSet<Departament_Dades> result = db.query(p); 
        
        if (result.size() != 1) {
            System.out.println("No es pot eliminar aquest departament. N'hi ha més d'1 o 0 amb el mateix ID en la BD.");
        } else {
        	Departament_Dades d = result.next();
        	
        	System.out.println("ELIMINAT EL DEPARTAMENT " + d.getNom());
            
            db.delete(d);
        }
	}
	
	
	
	// menu 41: Esborrat en cascada del departament Comandament
	// Fem un esborrat EN CASCADA del departament Comandament a veure si s'esborra la seva llista d'encàrrecs automàticament i quins dels
	// productes, que té assignats als seus encàrrecs, s'esborren  automàticament de la base de dades.
	public static ObjectContainer menu41(ObjectContainer db) {
		int departamentAEsborrar;
		
		
		// Tanquem la BD perquè l'hem d'obrir afegint l'opció d'esborrar en CASCADE.
		db.close();
		
		// Aquesta configuració és perquè esborri en cascada quan fem un delete de qualsevol objecte del nostre
    	// programa (<Departament_Dades>, <Encarrec_Dades> o <Producte_Dades>) que contingui altres objectes.
    	EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
        config.common().objectClass(Departament_Dades.class).cascadeOnDelete(true);
        config.common().objectClass(Encarrec_Dades.class).cascadeOnDelete(true);
        config.common().objectClass(Producte_Dades.class).cascadeOnDelete(true);
        db = Db4oEmbedded.openFile(config, IKSRotarranConstants.pathBD);
		
        departamentAEsborrar = 1;	
		
		Predicate p = new Predicate<Departament_Dades>() { 
            @Override 
            public boolean match(Departament_Dades d) { 
                if (d.getId() == departamentAEsborrar) {
                	return true;
                } else {
                	return false;
                }
            } 
        }; 
        
        ObjectSet<Departament_Dades> result = db.query(p); 
        
        if (result.size() != 1) {
            System.out.println("No es pot eliminar aquest departament. N'hi ha més d'1 o 0 amb el mateix ID en la BD.");
        } else {
        	Departament_Dades d = result.next();
        	
        	System.out.println("ELIMINAT EN CASCADA EL DEPARTAMENT " + d.getNom());
            
            db.delete(d);
        }
        
        // Retornem la BD sense la capacitat d'esborrar en cascada.
        db.close();
        config = Db4oEmbedded.newConfiguration();
        config.common().objectClass(Departament_Dades.class).cascadeOnUpdate(true);		// D'aquesta manera s'updateja els objectes <Encarrec_Dades> que hi ha a dins.
        config.common().objectClass(Encarrec_Dades.class).cascadeOnUpdate(true);	// D'aquesta manera s'updateja els objectes <Producte_Dades> que hi ha a dins.
        config.common().objectClass(Producte_Dades.class).cascadeOnUpdate(true);	// No hauria de fer falta.
        db = Db4oEmbedded.openFile(config, IKSRotarranConstants.pathBD);
        
        return db;
	}
	
	
}
