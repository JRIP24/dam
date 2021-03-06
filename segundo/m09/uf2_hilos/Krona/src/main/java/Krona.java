
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
            menu.append("6. Modificar coordenades i nom dels waypoint de l'ArrayList amd ID parell");
            menu.append(System.getProperty("line.separator"));
            menu.append("7. Visualitzar els waypoints de l'ArrayList ordenats");
            menu.append(System.getProperty("line.separator"));
            menu.append("8. Llistar els waypoints de l'ArrayList que es trobin a certa distància de la Terra");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator"));
            
            menu.append("10. Inicialitzar una ruta");
            menu.append(System.getProperty("line.separator"));
            menu.append("11. Visualitzar una ruta");
            menu.append(System.getProperty("line.separator"));
            menu.append("12. Invertir una ruta)");
            menu.append(System.getProperty("line.separator"));
            menu.append("13. Existeix el waypoint 'Òrbita de Júpiter REPETIDA' en la ruta?");
            menu.append(System.getProperty("line.separator"));
            /*menu.append("14. Llistar els waypoints d'una ruta");
            menu.append(System.getProperty("line.separator"));
            menu.append("15. Crear una ruta");
            menu.append(System.getProperty("line.separator"));
            menu.append("16. Modificar una ruta");
            menu.append(System.getProperty("line.separator"));
            menu.append("17. Llistar les rutes que tinguin un waypoint concret");
            menu.append(System.getProperty("line.separator"));
            menu.append("18. Donar de baixa una ruta");
            menu.append(System.getProperty("line.separator"));
            menu.append("19. Esborrar de la BD una ruta");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator"));*/
            
            menu.append("20. Inicialitzar llista de rutes");
            menu.append(System.getProperty("line.separator"));
            menu.append("21. Ficar tots els waypoints en un set");
            menu.append(System.getProperty("line.separator"));
            menu.append("22. Waypoints que estan en totes les rutes");
            menu.append(System.getProperty("line.separator"));
            menu.append("23. Waypoints que estan en la ruta A i no en la ruta B");
            menu.append(System.getProperty("line.separator"));
            menu.append("24. Ordenar les rutes per waypoints i ID (el ID de més gran a més petit)");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator"));
            
            menu.append("30. Crear un MAP de rutes i visualitzar-lo");
            menu.append(System.getProperty("line.separator"));
            
            menu.append("31. Visualitza totes les rutes del MAP que tinguin un waypoint concret");
            menu.append(System.getProperty("line.separator"));
            
            menu.append("32. Esborrar totes les rutes del MAP que tinguin un waypoint concret");
            menu.append(System.getProperty("line.separator"));
            
            menu.append("33. Visualitzar les dades d'una ruta");
            menu.append(System.getProperty("line.separator"));
            
            menu.append("34. Ordenar les rutes del MAP per ID");
            menu.append(System.getProperty("line.separator"));
            
            menu.append("35. Ordenar les rutes del MAP per waypoints i ID (el ID de més gran a més petit)");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator"));
            
            menu.append("40. Inicialitzar waypoints");
            menu.append(System.getProperty("line.separator"));
            
            menu.append("41. Insertar un nou waypoint");
            menu.append(System.getProperty("line.separator"));
            
            menu.append("42. Visualitzar el waypoints versus un tipus");
            menu.append(System.getProperty("line.separator"));
            
            menu.append("43. Visualitzar el nº de waypoints versus el seu tipus");
            menu.append(System.getProperty("line.separator"));
            
            menu.append("44. Trobar waypoints versus el seu nom");
            menu.append(System.getProperty("line.separator"));
            
            menu.append("45. Ordenar els waypoints per data");
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
                	comprovacioRendimentTmp = Waypoint.esborrarWaypoints(comprovacioRendimentTmp);
                    bloquejarPantalla();
                    break;
                case "6":
                	
                	comprovacioRendimentTmp = Waypoint.modificarCoordenadesINomDeWaypoints(comprovacioRendimentTmp);
                    bloquejarPantalla();
                    break;
                    
                case "7":
                	Waypoint.waypointsACertaDistanciaMaxDeLaTerra(comprovacioRendimentTmp);
                    bloquejarPantalla();
                    break;
                    
                case "8":
                	Waypoint.visualitzarWaypointsOrdenats(comprovacioRendimentTmp);
                    bloquejarPantalla();
                    break;
                    
                case "10"://Se tiene que haber ejecutado la opción 1 antes
                	comprovacioRendimentTmp = Ruta.inicialitzarRuta(comprovacioRendimentTmp);                    
                    bloquejarPantalla();
                    break;
                    
                case "11"://Se tiene que haber ejecutado la opción 10 antes
                	Ruta.visualitzarRuta(comprovacioRendimentTmp);                    
                    bloquejarPantalla();
                    break;
                    
                case "12"://Se tiene que haber ejecutado la opción 10 previamente
                    Ruta.invertirRuta(comprovacioRendimentTmp);
                    bloquejarPantalla();
                    break;
                case "13":
                	Ruta.existeixWaypointEnRuta(comprovacioRendimentTmp);
                    bloquejarPantalla();
                    break;
                case "15":
                    
                    bloquejarPantalla();
                    break;
                case "19":
                    
                    bloquejarPantalla();
                    break;
                    
                case "20":
                	comprovacioRendimentTmp = Ruta.inicialitzaLListaRutes(comprovacioRendimentTmp);
                    bloquejarPantalla();
                    break;
                    
				case "21":
					
					Ruta.setUnio(comprovacioRendimentTmp);
				    bloquejarPantalla();
				    break;
				    
				case "22":
					
					Ruta.setInterseccio(comprovacioRendimentTmp);				    
				    bloquejarPantalla();
				    break;
				    
				case "23":
				    
				    bloquejarPantalla();
				    break;
				    
				case "24":
				    
				    bloquejarPantalla();
				    break;
				    
				case "40":
					
					Waypoint.m40(comprovacioRendimentTmp);
				    
				    bloquejarPantalla();
				    break;
				    
			    
				case "41":
					
					Waypoint.m41(comprovacioRendimentTmp);
				    bloquejarPantalla();
				    break;
				    
				case "42":
					
					Waypoint.m42(comprovacioRendimentTmp);
				    bloquejarPantalla();
				    break;
				    
				    
				case "43":
					Waypoint.m43(comprovacioRendimentTmp);
				    bloquejarPantalla();
				    break;
				    
				    
				case "44":
				    Waypoint.m44(comprovacioRendimentTmp);
				    bloquejarPantalla();
				    break;
				    
				case "45":
				    //Mirar Clase Llibreries/ComparaFechas
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
