package org.github.ronald.obd;
import java.time.LocalDateTime;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;



public class Encarrec {
	
	// menu 2: Crea encarrecs i els fica en la BD per inicialitzar-la.
	public static void menu2(ObjectContainer db) {

		Encarrec_Dades[] encarrecs = {
            new Encarrec_Dades(0, 1, LocalDateTime.now()),
            new Encarrec_Dades(1, 1, LocalDateTime.now()),
            new Encarrec_Dades(2, 3, LocalDateTime.now()),
            new Encarrec_Dades(3, 1, LocalDateTime.now()),
            new Encarrec_Dades(4, 1, LocalDateTime.now()),
            new Encarrec_Dades(5, 4, LocalDateTime.now()),
            new Encarrec_Dades(6, 3, LocalDateTime.now())
        };
		
		for(int i = 0; i < encarrecs.length; i++) {
			//S'emmagatzema encarrecs[i].
            db.store(encarrecs[i]);   		
        }
	}
	

	// menu 11: Veure tots els encàrrecs que hi ha en la BD
	public static void menu11(ObjectContainer db) {
		Predicate p = new Predicate<Encarrec_Dades>() { 
	        @Override 
	        public boolean match(Encarrec_Dades c) { 
	            return true; 
	        } 
	    }; 
	    
	    ObjectSet<Encarrec_Dades> result = db.query(p); 
	    
	    while (result.hasNext()) { 
	    	Encarrec_Dades encarrecTmp = result.next(); 
	        System.out.println(encarrecTmp.toString()); 
	    } 
	}
}
