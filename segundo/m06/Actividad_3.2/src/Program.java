import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Program {
	
	
	public static void pausar(){
		
		Scanner scanner = new Scanner(System.in);
	    boolean exit = false;
	    
	    while(!exit) {
	    	
	    	System.out.println("Presione 'Enter' para continuar");
		    String readString = scanner.nextLine();

	        if (readString.isEmpty()) {
	        	System.out.println("\n \n");
	        	
	            exit = true;
	            
	        }
	    }
		
	}
	
	
	public static void leerSeq(ArrayList<Assignatura> asignaturas, String ruta) throws SAXException, IOException, ParserConfigurationException {
		
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(ruta);
        
        Node raiz = doc.getDocumentElement();
        NodeList nodos = raiz.getChildNodes();
        
        System.out.println("Asignaturas: " + nodos.getLength());
        
        for (int i=0; i<nodos.getLength(); i++) {
        	
        	if (nodos.item(i).getNodeName().equals("asignatura")) {//Recogemos datos de cada asignatura
        		
        		NodeList listaAsignaturas = nodos.item(i).getChildNodes();
        		String nom = "";
        		int numero = 0;
        		int durada = 0;
        		ArrayList<Alumne> alumnos = new ArrayList<Alumne>();
        		
        		
        		
        		for (int j=0; j<listaAsignaturas.getLength(); j++) {
        			
        			if(listaAsignaturas.item(j).getNodeName().equals("numero")) {
        				
        				numero = Integer.parseInt(listaAsignaturas.item(j).getTextContent());
        				
        			}
                
        			if(listaAsignaturas.item(j).getNodeName().equals("nom")) {
        				
        				nom = listaAsignaturas.item(j).getTextContent();
        				
        			}
        			
        			if(listaAsignaturas.item(j).getNodeName().equals("durada")) {
        				
        				durada = Integer.parseInt(listaAsignaturas.item(j).getTextContent());
        				
        			}
        			
        			if (listaAsignaturas.item(j).getNodeName().equals("alumnos")) { //Recogemos la lista de alumnos
						
        				
        				NodeList listaAlumnos = listaAsignaturas.item(j).getChildNodes();
        				
                        for (int x = 0; x < listaAlumnos.getLength(); x++) {
                        	
                        	Alumne alumno = new Alumne();
                        	
                        	if (listaAlumnos.item(x).getNodeName().equals("nom")) {
                        		
								alumno.setNom(listaAlumnos.item(x).getTextContent());
							}
                        	
                        	if (listaAlumnos.item(x).getNodeName().equals("dni")) {
								
                        		alumno.setDni(listaAlumnos.item(x).getTextContent());
                        		
							}


							if (listaAlumnos.item(x).getNodeName().equals("repetidor")) {
								
								alumno.setRepetidor(Boolean.valueOf(listaAlumnos.item(x).getTextContent()));
								
							}
                        	
                        	
                        	
                        	
                        	alumnos.add(alumno);
                            
                        }  

        				
        				
        				
					}
        			
        			
        			asignaturas.add(new Assignatura(numero, nom, durada, alumnos));
        			
        			
                }

        		
        	}
        	
        }


		
	}
	
	
	
	
	
	public static void leerSin(ArrayList<Assignatura> asignaturas, String ruta) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
		
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(ruta);
        
        XPathExpression expr = XPathFactory.newInstance().newXPath().compile("/asignaturas/asignatura");
	    NodeList listaAsignaturas = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
	    
	    
	    String nom = "";
		int numero = 0;
		int durada = 0;
		ArrayList<Alumne> alumnos = new ArrayList<Alumne>();
		
		for (int j=0; j<listaAsignaturas.getLength(); j++) {
			
			Assignatura assignatura = new Assignatura();
			assignatura.leer(listaAsignaturas.item(j));
			asignaturas.add(assignatura);
			
			
			/*
			System.out.println( "Nombre nodo" +  listaAsignaturas.item(j).getNodeName());
			
			if(listaAsignaturas.item(j).getNodeName().equals("numero")) {
				
				numero = Integer.parseInt(listaAsignaturas.item(j).getTextContent());
				System.out.println("Numero: " + numero);
				
			}else if(listaAsignaturas.item(j).getNodeName().equals("nom")) {
				
				nom = listaAsignaturas.item(j).getTextContent();
				System.out.println("Nombre: " + nom);
				
			}else if(listaAsignaturas.item(j).getNodeName().equals("durada")) {
				
				durada = Integer.parseInt(listaAsignaturas.item(j).getTextContent());
				System.out.println("Durada: " + durada);
				
			} else if (listaAsignaturas.item(j).getNodeName().equals("alumnos")) { //Recogemos la lista de alumnos
				
				
				NodeList listaAlumnos = listaAsignaturas.item(j).getChildNodes();
				
                for (int x = 0; x < listaAlumnos.getLength(); x++) {
                	
                	Alumne alumno = new Alumne();
                	
                	if (listaAlumnos.item(x).getNodeName().equals("nom")) {
                		
						alumno.setNom(listaAlumnos.item(x).getTextContent());
					}
                	
                	if (listaAlumnos.item(x).getNodeName().equals("dni")) {
						
                		alumno.setDni(listaAlumnos.item(x).getTextContent());
                		
					}


					if (listaAlumnos.item(x).getNodeName().equals("repetidor")) {
						
						alumno.setRepetidor(Boolean.valueOf(listaAlumnos.item(x).getTextContent()));
						
					}
                	
                	
                	
                	
                	alumnos.add(alumno);
                    
                }  

				
				
				
			}
			
			
			asignaturas.add(new Assignatura(numero, nom, durada, alumnos));
			*/
			
        }
	    
	    
	    
	}
	
	static void guardarXML(String ruta, ArrayList<Assignatura> asignaturas) throws ParserConfigurationException, TransformerException {
		
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		Element nodoAsignaturas = doc.createElement("asignaturas");//Raíz
        doc.appendChild(nodoAsignaturas);
        
        for (Assignatura assignatura : asignaturas) {
			
        	assignatura.guardarXML(nodoAsignaturas, doc);
		}
        
        Transformer trans = TransformerFactory.newInstance().newTransformer();
        StreamResult result = new StreamResult(new File (ruta));
        DOMSource source = new DOMSource(doc);
        trans.transform(source, result);

        
        


		
	}
	
	
	static String getFile() {
		
		String file = null;
		Scanner sc = new Scanner(System.in);
		boolean salir = false;
		
		
		while (!salir) {
			
			System.out.print("Introduzca la ruta absoluta de un archivo .xml: ");
			file = sc.nextLine();
			
			 File archivo = new File(file); 
			
			if(archivo.exists() && archivo.isFile()) {
				
				salir = true;				
				
			} else {
				
				System.out.println("El archivo introducido no existe");
			}
			
		}
		
		return file;
	}
	
	static int findIndex(int numero, ArrayList<Assignatura> assignaturas) {
		
		int indice = -1;
		
		for (int i = 0; i < assignaturas.size(); i++) {
			
			if (assignaturas.get(i).getNumero() == numero) {
				
				indice = i;
				break;
				
			} 
			
		}
		
		return indice;
		
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException, TransformerException {
		
		
		ArrayList<Assignatura> asignaturas = new ArrayList<Assignatura>();
		boolean salir = false;
		String archivo = "";
		String archivoXML = "Asignaturas.xml";
		
		
		while (!salir) {
			
			Scanner teclado = new Scanner(System.in); 
			
			System.out.println("*************************");
			System.out.println("*                       *");
			System.out.println("*     ACTIVIDAD 3.2     *");
			System.out.println("*                       *");
			System.out.println("************************* \n");
			
			System.out.println("0 - Salir");
			System.out.println("1 - Leer un archivo XML por el método secuencial");
			System.out.println("2 - Leer un archivo XML por el método sintáctico");
			System.out.println("3 - Mostrar todas las asignaturas");
			System.out.println("4 - Añadir una asignatura");
			System.out.println("5 - Añadir un alumno a una asignatura");
			System.out.println("6 - Guardar en disco un XML con las asignaturas \n \n");
			
			System.out.print("Introduzca una opción: ");
			
			if (teclado.hasNextInt()) {
				
				int opcion = teclado.nextInt();
				
				switch (opcion) {
				case 0:
					
					System.out.println("Saliendo...");
					salir = true;
					
					break;
					
				case 1:
					
					System.out.println("Opcion 1");
					
					archivo = getFile();
					
					leerSeq(asignaturas, archivo);
					
					pausar();
					
					break;
					
					
				case 2:
					
					System.out.println("Opcion 2");
					
					archivo = getFile();
					
					leerSin(asignaturas, archivo);
					pausar();
					
					break;
					
				case 3:
					
					System.out.println("Opcion 3");
					
					for (Assignatura assignatura : asignaturas) {
						
						assignatura.imprimir();
					}
					
					pausar();
					
					break;
					
					
				case 4:
					
					System.out.println("Opcion 4");
					
					System.out.print("Introduzca el número de la asignatura: ");
					
					if(teclado.hasNextInt()) {
						
						int numero = teclado.nextInt();
						
						System.out.print("Introduzca el nombre de la asignatura: ");
						
						String nombre = teclado.nextLine();
						teclado.next();
						
						System.out.print("Introduzca la duración de la asignatura: ");
						
						if (teclado.hasNextInt()) {
							
							int durada = teclado.nextInt();
							
							Assignatura assignatura = new Assignatura(numero, nombre, durada);
							
							//assignatura.addAlumnes();
							
							asignaturas.add(assignatura);
							
							
						} else {
							
							System.out.println("Error: No se ha introducido un número");
						}
						
						
					} else {
						
						System.out.println("Error: No se ha introducido un número");
					}
					
					pausar();
					
					break;
					
					
				case 5:
					
					System.out.println("Opcion 5");
					
					System.out.print("Introduzca el número de la asignatura: ");
					
					if(teclado.hasNextInt()) {
						
						int numero = teclado.nextInt();
						
						int indice = findIndex(numero, asignaturas);
						
						if (indice == -1) {
							
							System.out.println("No se ha encontrado la asignatura nº " + numero);
							
						} else {
							asignaturas.get(indice).addAlumnes();
						}
						
						
						
					} else {
						
						System.out.println("Error: No se ha introducido un número");
					}
					pausar();
					
					break;
					
					
					
				case 6:
					
					System.out.println("Opcion 6");
					guardarXML(archivoXML, asignaturas);
					
					pausar();
					
					break;
				
			

				default:
					
					System.out.println("Error: se debe introducir un número del 0 al 6");
					pausar();
					
					break;
				}
				
				
				
			} else {
				
				System.out.println("Error: No se ha introducido ningún número");
				pausar();
				
			}
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
	}
}
