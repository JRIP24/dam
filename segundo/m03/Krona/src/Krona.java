
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author gmartinez
 */

public class Krona {
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
    
    
    public static void menuKrona() throws IOException  {
        String opcio;
        Scanner sc = new Scanner(System.in);
        StringBuilder menu = new StringBuilder("");
        
        ComprovacioRendiment comprovacioRendimentTmp = null;
        
        do {
            menu.delete(0, menu.length());
            
            menu.append(System.getProperty("line.separator"));
            menu.append("RV-18A Krona ");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator")); 
            
            menu.append("1. Inicialitzar el procés de comprovació d'un ArrayList i un LinkedList de waypoints");
            menu.append(System.getProperty("line.separator"));
            menu.append("2. Comprovar rendiment d'inicialització d'un ArrayList i un LinkedList de waypoints");
            menu.append(System.getProperty("line.separator"));
            menu.append("3. Comprovar rendiment d'inserció en un ArrayList i en un LinkedList de waypoints");
            menu.append(System.getProperty("line.separator"));
            menu.append("4. Modificació dels waypoints de l'ArrayList i del LinkedList");
            menu.append(System.getProperty("line.separator"));
            menu.append("5. Esborrar waypoints de l'ArrayList i del LinkedList");
            menu.append(System.getProperty("line.separator"));
            menu.append("6. ");
            menu.append(System.getProperty("line.separator"));
            menu.append("7. ");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator"));
            
            menu.append("10. ");
            menu.append(System.getProperty("line.separator"));
            menu.append("11. ");
            menu.append(System.getProperty("line.separator"));
            menu.append("12. ");
            menu.append(System.getProperty("line.separator"));
            menu.append("13. ");
            menu.append(System.getProperty("line.separator"));
            menu.append("14. ");
            menu.append(System.getProperty("line.separator"));
            menu.append("15. ");
            menu.append(System.getProperty("line.separator"));
            menu.append("16. ");
            menu.append(System.getProperty("line.separator"));
            menu.append("17. ");
            menu.append(System.getProperty("line.separator"));
            menu.append("18. ");
            menu.append(System.getProperty("line.separator"));
            menu.append("19. ");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator"));
            
            menu.append("20. ");
            menu.append(System.getProperty("line.separator"));
            menu.append("21. ");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator"));
            
            menu.append("50. Tornar al menú pare (PNS-24 Puma)");
            menu.append(System.getProperty("line.separator"));
            
            
            System.out.print(MenuConstructorPantalla.constructorPantalla(menu));
            
            opcio = sc.next();
            
            
            switch (opcio) {
                case "1":
                	comprovacioRendimentTmp = Waypoint.inicialitzarComprovacioRendiment();
                    bloquejarPantalla();
                    break;
                case "2":
                	comprovacioRendimentTmp = Waypoint.comprovarRendimentInicialitzacio(10, comprovacioRendimentTmp);
                    bloquejarPantalla();
                    break;
                case "3":
                	comprovacioRendimentTmp = Waypoint.comprovarRendimentInsercio(comprovacioRendimentTmp);
                    bloquejarPantalla();
                    break;
                case "4":
                	comprovacioRendimentTmp = Waypoint.modificarWaypoints(comprovacioRendimentTmp);
                    bloquejarPantalla();
                    break;
                case "5":
                	//comprovacioRendimentTmp = Waypoint.esborrarWaypoints(comprovacioRendimentTmp);
                    bloquejarPantalla();
                    break;
                case "6":
                    
                    bloquejarPantalla();
                    break;
                case "7":
                    
                    bloquejarPantalla();
                    break;
                case "10":
                    
                    bloquejarPantalla();
                    break;    
                case "12":
                    
                    bloquejarPantalla();
                    break;
                case "13":
                    
                    bloquejarPantalla();
                    break;
                case "15":
                    
                    bloquejarPantalla();
                    break;
                case "19":
                    
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
