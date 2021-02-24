import Pantalles.MenuConstructorPantalla;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;



/**
 *
 * @author gmartinez
 */
public class PAU_487 {
    /*
    SISTEMA DE NAVEGACIÓ BASAT EN WAYPOINTS.
    ES DONEN D'ALTA DIVERSOS WAYPOINTS DE L'ESPAI (ORBITA MARCIANA, PUNT LAGRANGE TERRA-LLUNA, PHOBOS, SATURN, LLUNA,...).
    ES PODEN MEMORITZAR DIVERSES RUTES AFEGINT DIVERSOS WAYPOINTS A CADA RUTA.
    
    */
    
    public static void bloquejarPantalla() {
        Scanner in = new Scanner(System.in);
        System.out.print("\nToca 'C' per a continuar ");
        while (in.hasNext()) {
            if ("C".equalsIgnoreCase(in.next())) break;
        }
    }
    
    
    public static void menuPAU_487() { //throws IOException  {
        String opcio;
        Scanner sc = new Scanner(System.in);
        StringBuilder menu = new StringBuilder("");
        
        do {
            menu.delete(0, menu.length());
            
            menu.append(System.getProperty("line.separator"));
            menu.append("PAU-487");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator")); 
            
            menu.append("1. Threads implements Runnable");
            menu.append(System.getProperty("line.separator"));
            menu.append("2. Threads extends Thread (I)");
            menu.append(System.getProperty("line.separator"));
            menu.append("3. Threads extends Thread (II)");
            menu.append(System.getProperty("line.separator"));
            menu.append("4. Threads amb wait()i notify()");
            menu.append(System.getProperty("line.separator"));
            menu.append("5. ");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator"));
            
            menu.append("50. Tornar al menú pare (PNS-24 Puma)");
            menu.append(System.getProperty("line.separator"));
            
            
            System.out.print(MenuConstructorPantalla.constructorPantalla(menu));
            
            opcio = sc.next();
            
            
            switch (opcio) {
                case "1":
					try {
						Exercici_1.inicialitzarPrograma();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    bloquejarPantalla();
                    break;
                case "2":
                    Exercici_2_v1.inicialitzarPrograma();
                    bloquejarPantalla();
                    break;
                case "3":
                    Exercici_2_v2.inicialitzarPrograma();
                    bloquejarPantalla();
                    break;
                case "4":

                    bloquejarPantalla();
                    break;
                case "5":

                    bloquejarPantalla();
                    break;
                case "50":
                    break; 
                default:
                    System.out.println("COMANDA NO RECONEGUDA");
            }   
        } while (!opcio.equals("50"));
    }
    
}
