import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Program {
	
	
	///2
	
	public static void desarPc(List<Ordinador> llistaEnters) throws FileNotFoundException, IOException {
        DataOutputStream streamEscriptura = new DataOutputStream(new
        BufferedOutputStream(new FileOutputStream(ruta)));

        try {
            streamEscriptura.writeInt(llistaEnters.size()); // desem quants enters hi ha
            for (int i=0; i < llistaEnters.size(); i++) {
                streamEscriptura.writeInt(llistaEnters.get(i)); // desem cada enter
            }
        }
        finally {
            streamEscriptura.close();
        }
    }
	
	 public void guardarPc(String ruta, ArrayList<Ordinador> listaPc) throws IOException {
	        ObjectOutputStream sortida = null;
	        
	        for (Ordinador ordinador : listaPc) {
	        	try {
		            sortida = new ObjectOutputStream(new FileOutputStream(ruta));
		            sortida.writeObject(ordinador); // guardem el propi treballador
		        }
		        finally {
		            sortida.close();
		        }
			}
	        
	        
	    }
	 
	 
	 public ArrayList<Ordinador> leerPcs(String ruta) throws IOException, ClassNotFoundException {
		 
		 
		 	ArrayList<Ordinador> listaPc = new ArrayList<Ordinador>();
		 	
	        ObjectInputStream entrada = null;
	        try {
	            entrada = new ObjectInputStream(new FileInputStream(ruta));
	            
	            Ordinador llegit = (Ordinador) entrada.readObject(); 
	            listaPc.add(llegit);
	            
	            
	        }
	        finally {
	            entrada.close();
	        }
	    }

	 
	 
	 
	 
	 public static void guardar(List<Integer> llistaEnters, String ruta) throws FileNotFoundException, IOException {
	        DataOutputStream streamEscriptura = new DataOutputStream(new
	        BufferedOutputStream(new FileOutputStream(ruta)));

	        try {
	            streamEscriptura.writeInt(llistaEnters.size());
	            for (int i=0; i < llistaEnters.size(); i++) {
	                streamEscriptura.writeInt(llistaEnters.get(i));
	            }
	        }
	        finally {
	            streamEscriptura.close();
	        }
	    }

	    
	 
	 public void desar_xml(String ruta, ArrayList<Pelicula> peliculas) throws ParserConfigurationException, TransformerConfigurationException, TransformerException {
		 
	        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
	     
	        // tag raiz
	        Element nodoPeliculas = doc.createElement("peliculas");
	        doc.appendChild(nodoPeliculas);
	        
	        for (Pelicula pelicula : peliculas) {
	        	
	        	Element nodePelicula= doc.createElement("pelicula");
		        nodePelicula.setTextContent(pelicula.nom);
		        nodoPeliculas.appendChild(nodePelicula);
		        
		        Element nodoResenyes = doc.createElement("ressenyes");
		        nodePelicula.appendChild(nodoResenyes);
		        
		        for (Ressenya ressenya : pelicula.ressenyes) {  
			        
		        	Element nodoResenya = doc.createElement("ressenya");
		        	
		        	nodoResenyes.appendChild(nodoResenya);
		        	
		        	Element nodoPuntuacio = doc.createElement("puntuacio");
		        	nodoPuntuacio.setTextContent(ressenya.puntuacio);
		        	nodoResenya.appendChild(nodoPuntuacio);
		        	
		        	Element nodoText = doc.createElement("text");
		        	nodoText.setTextContent(ressenya.text);
		        	nodoResenya.appendChild(nodoText);
		        	
				}
		        
		        
	        }
	        
	        // fem el desat a disc
	        TransformerFactory.newInstance().newTransformer().
	         transform(new DOMSource(doc), new StreamResult(new File (ruta)));
	    }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 public int llegir_sequencial(String ruta) throws ParserConfigurationException, SAXException, IOException {
	        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(ruta);
	        Node arrel = doc.getDocumentElement();
	        NodeList llistaNodes = arrel.getChildNodes();
	        
	        
	         
	            if (llistaNodes.item(0).getNodeName().equals("pelicula")) {
	            	
	            NodeList listaPelis = llistaNodes.item(i).getChildNodes();
	            	
	            	if (listaPelis.item(0).getNodeName().equals("ressenyes")) {
	            			
	            	NodeList listaRessenyes = listaPelis.item(0).getChildNodes();
	            
        			
        	
	            		
	            		if (listaRessenyes.item(0).getNodeName().equals("ressenya")) {
	            			
	            			
	                        return Integer.parseInt(listaRessenyes.item(0).getTextContent());
	            			
							
						}
	            		
	    	            	
	            			
							
	            	}
	            		
	            	}
	            	
	  }
	            	
	            	
	                
	           
	 
	 
	 
	 
	 
	 
	 
	 public int llegir_sintactic(String ruta) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
	        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(ruta);
	        
	        XPathExpression expr = XPathFactory.newInstance().newXPath().compile("/peliculas/pelicula[0]/ressenyes/ressenya[0]/puntuacio");
	        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
	        
	        return Integer.parseInt(node.getTextContent());
	      
	        
	    }



	
	
	
	public static void main(String[] args) {
		
		File archivo = new File("/home/ronald");
		
		for (String string : archivo.list()) {
			
			File dire = new File(string);
			
			System.out.println( string + "\t" + dire.lastModified());
		}
		
		
		
		
	}

}
