import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

//import DBOO_exercicis_antics_Leonov_2019_2020.TipusMissatges_Dades;
//import exemple_apartat_1_3_2.Client;

public class Producte {
	
	// static: per aconseguir que la dada afectada sigui comuna a tots els objectes creats d'una mateixa classe.
	// Variable que farem servir per a passar un valor a un predicate per així poder filtrar la búsqueda en la BD.
	public static Producte_Dades producteDelXML;
	

	// menu 1: Crea productes i els fica en la BD per inicialitzar-la. 
	public static void menu1(ObjectContainer db) {
		Producte_Dades[] productes = {
                new Producte_Dades(1, "Ració de combat", 1, 0),
                new Producte_Dades(2, "Torpede mark 2", 100, 2),
                new Producte_Dades(3, "Autopilot SAU-6", 10, 3),
                new Producte_Dades(4, "Sistema inercial MIS-P", 11, 3),
                new Producte_Dades(5, "Bobina d'inducció magnètica del reactor principal", 10000, 4),
                new Producte_Dades(6, "Sistema de navegació de llarg abast RSDN-10", 12, 3)
		};
		
		for(int i = 0; i < productes.length; i++) {
			//S'emmagatzema productes[i].
            db.store(productes[i]);   		
        }
	}
	
	
	
	// menu 10: LLista per pantalla tots els productes que hi ha en la BD.
	public static void menu10(ObjectContainer db) {
		Predicate p = new Predicate<Producte_Dades>() { 
            @Override 
            public boolean match(Producte_Dades c) { 
                return true; 
            } 
        }; 
        
        List<Producte_Dades> result = db.query(p); 
        
        for (Producte_Dades producteTmp : result) { 
            System.out.println(producteTmp.toString()); 
        } 
	}
	
	
	
	
	// menu 20: Exporta els productes a un XML
	public static void menu20(ObjectContainer db, String pathArxiusXML) {
		ArrayList<Producte_Dades> llistaOrdenadaProductes;
		XMLEncoder e = null;
		
		
		Predicate p = new Predicate<Producte_Dades>() { 
            @Override 
            public boolean match(Producte_Dades c) { 
                return true; 
            } 
        }; 
        
        List<Producte_Dades> result = db.query(p);
        
        llistaOrdenadaProductes = new ArrayList<Producte_Dades>();
        llistaOrdenadaProductes.addAll(result);
        
        // Ordenenem alfabéticament els productes. Fa servir el compareTo() que hi ha en Producte_Dades.
        Collections.sort(llistaOrdenadaProductes);
        
		// Serialització
        try {
			e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(pathArxiusXML)));
			
			for (Producte_Dades producteTmp : llistaOrdenadaProductes) { 
				e.writeObject(producteTmp); 
	        } 
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			e.close();	
		}
	}
	
	
	// menu 21: Importa en la BD els productes que hi ha en el XML
	// https://howtodoinjava.com/java/serialization/xmlencoder-and-xmldecoder-example/
	// Carrega en memòria els productes que hi ha en el fitxer productes.xml, busca'ls en 
	// la BD (seran iguals si tenen el mateix producteId) i fes INSERT o UPDATE segons els cas.
	public static void menu21(ObjectContainer db, String pathArxiusXML) {
		XMLDecoder d = null;
		//Producte_Dades producteDelXML;		// L'hem hagut de declarar com atribut de la classe perquè pugui ser "static".

		
		// Recuperem les dades del XML.
        try {
        	d = new XMLDecoder(new BufferedInputStream(new FileInputStream(pathArxiusXML)));
        	
            while ((producteDelXML = (Producte_Dades) d.readObject()) != null){
            	System.out.println();
            	
                Predicate p = new Predicate<Producte_Dades>() { 
                    @Override 
                    public boolean match(Producte_Dades c) { 
                        return c.getProducteId() == producteDelXML.getProducteId();
                    } 
                }; 

                //En result tenim els objectes que s'han trobat en la BD que compleixen la condició de filtratge (la query).
                ObjectSet<Producte_Dades> result = db.query(p);       
                
                if (!result.isEmpty()) {
                    //Hem trobat en la BD un producte amb el mateix ID. L'anem a updatejar.
                    
                	Producte_Dades producteTrobatEnLaBD = result.next();  //producteTrobatEnLaBD apunta al mateix objecte que el trobat en la BD.
                    
                    System.out.println("menu21(): UPDATE");
                    System.out.println("producte ID: " + producteTrobatEnLaBD.getProducteId() + ", nom: " + producteTrobatEnLaBD.getProducteNom() + ", preu: " + producteTrobatEnLaBD.getProductePreu());
                    System.out.println("canviat a");
                    System.out.println("producte ID: " + producteDelXML.getProducteId() + ", nom: " + producteDelXML.getProducteNom() + ", preu: " + producteDelXML.getProductePreu());
                    
                    producteTrobatEnLaBD.setProducteNom(producteDelXML.getProducteNom());
                    producteTrobatEnLaBD.setProductePreu(producteDelXML.getProductePreu() * 2);

                    db.store(producteTrobatEnLaBD);
                    
                } else{
                    //No hem trobat en la BD un producte amb el mateix ID. L'insertem.

                    System.out.println("menu21(): INSERT");
                    System.out.println("producte ID: " + producteDelXML.getProducteId() + ", nom: " + producteDelXML.getProducteNom() + ", preu: " + producteDelXML.getProductePreu());
                    
                    db.store(producteDelXML);
                }
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            // Així controlem que hem arribat al final del fitxer perquè el "d.readObject() != null" no va, ja que, ha intentat 
        	// llegir un objecte quan no n'hi havia cap i per tant ja no arriba ni a comparar-lo amb NULL.
        	System.out.println();
            System.out.println("NO HI HA MÉS PRODUCTES AL FITXER " + pathArxiusXML);
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            d.close();
            System.out.println();
            System.out.println("TANQUEM EL FITXER " + pathArxiusXML);
        }
		
	}
	
	
	
	
	
}
