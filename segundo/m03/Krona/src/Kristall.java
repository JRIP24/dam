import java.io.IOException;
import java.util.Scanner;

public class Kristall {
	
	public static void bloquejarPantalla() {
        Scanner in = new Scanner(System.in);
        System.out.print("\nToca 'C' per a continuar ");
        while (in.hasNext()) {
            if ("C".equalsIgnoreCase(in.next())) break;
        }
    }
    
    
    public static void menuKristall() throws IOException  {
        String opcio;
        Scanner sc = new Scanner(System.in);
        StringBuilder menu = new StringBuilder("");
        
        do {
            menu.delete(0, menu.length());
            
            menu.append(System.getProperty("line.separator"));
            menu.append("Kristall ");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator")); 
            
            menu.append("1. Comparar 2 fitxers");
            menu.append(System.getProperty("line.separator"));
            menu.append("2. Nº de línies i caràcters d'una llista d'arxius (I)");
            menu.append(System.getProperty("line.separator"));
            menu.append("3. Nº de línies i caràcters d'una llista d'arxius (II)");
            menu.append(System.getProperty("line.separator"));
            menu.append("4. Nº de repeticions de caràcters en un fitxer");
            menu.append(System.getProperty("line.separator"));
            menu.append("5. Links d'una URL a un fitxer");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator"));
            /*menu.append("6. Modificar coordenades i nom dels waypoint de l'ArrayList amd ID parell");
            menu.append(System.getProperty("line.separator"));
            menu.append("7. Visualitzar els waypoints de l'ArrayList ordenats");
            menu.append(System.getProperty("line.separator"));
            menu.append("8. Llistar els waypoints de l'ArrayList que es trobin a certa distància de la Terra");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator"));*/
            
            menu.append("10. Mostrar contingut d'un directori");
            menu.append(System.getProperty("line.separator"));
            menu.append("11. Fer copia seguretat d'un directori (còpia automàtica)");
            menu.append(System.getProperty("line.separator"));
            menu.append("12. Fer copia seguretat d'un directori (còpia manual)");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator"));
            /*menu.append("13. Existeix el waypoint 'Òrbita de Júpiter REPETIDA' en la ruta?");
            menu.append(System.getProperty("line.separator"));
            menu.append("14. Llistar els waypoints d'una ruta");
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
            
            menu.append("20. FileUtils (I)");
            menu.append(System.getProperty("line.separator"));
            menu.append("21. FileUtils (II)");
            menu.append(System.getProperty("line.separator"));
            menu.append("22. FileUtils (III)");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator"));
            /*
            menu.append(System.getProperty("line.separator"));
            menu.append("23. Waypoints que estan en la ruta A i no en la ruta B");
            menu.append(System.getProperty("line.separator"));
            menu.append("24. Ordenar les rutes per waypoints i ID (el ID de més gran a més petit)");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator"));*/
            
            menu.append("30. Guardar les naus amb RandomAccesFile");
            menu.append(System.getProperty("line.separator"));
            
            menu.append("31. Recuperar les naus amb RandomAccesFile");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator"));
         
            menu.append("50. Tornar al menú pare (PNS-24 Puma)");
            menu.append(System.getProperty("line.separator"));
            
            
            System.out.print(MenuConstructorPantalla.constructorPantalla(menu));
            
            opcio = sc.next();
            
            
            switch (opcio) {
                case "1":
                	
                	MetodesKristall.menu1();
                	
                    bloquejarPantalla();
                    break;
                case "2":
                	
                	MetodesKristall.menu2();
                	
                    bloquejarPantalla();
                    break;
                case "3":
                	//Parece el mismo de menu2
                    bloquejarPantalla();
                    break;
                case "4":
                	
                    bloquejarPantalla();
                    break;
                case "5":
                	
                    bloquejarPantalla();
                    break;
                case "6":
                	
                	
                    bloquejarPantalla();
                    break;
                    
                case "7":
                	
                    bloquejarPantalla();
                    break;
                    
                case "8":
                	
                    bloquejarPantalla();
                    break;
                    
                case "10"://Se tiene que haber ejecutado la opción 1 antes
                	                    
                    bloquejarPantalla();
                    break;
                    
                case "11"://Se tiene que haber ejecutado la opción 10 antes
                	                    
                    bloquejarPantalla();
                    break;
                    
                case "12"://Se tiene que haber ejecutado la opción 10 previamente
                    
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
                    
                case "20":
                	
                    bloquejarPantalla();
                    break;
                    
				case "21":
					
					
				    bloquejarPantalla();
				    break;
				    
				case "22":
					
									    
				    bloquejarPantalla();
				    break;
				    
				case "23":
				    
				    bloquejarPantalla();
				    break;
				    
				case "24":
				    
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
