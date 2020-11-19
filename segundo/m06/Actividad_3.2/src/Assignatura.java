import java.util.ArrayList;
import java.util.Scanner;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Assignatura {
	
	private int numero;
	private String nom;
	private int durada;
	private ArrayList<Alumne> listaAlumnes = new ArrayList<Alumne>();
	
	
	public Assignatura() {
		
	}
	
	
	public Assignatura(int numeroP, String nomP, int duradaP) {
		
		this.numero = numeroP;
		this.nom = nomP;
		this.durada = duradaP;
		
	}
	
	public Assignatura(int numeroP, String nomP, int duradaP, ArrayList<Alumne> alumnos) {
		
		this.numero = numeroP;
		this.nom = nomP;
		this.durada = duradaP;
		this.listaAlumnes = alumnos;
		
	}
	
	
	
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getDurada() {
		return durada;
	}


	public void setDurada(int durada) {
		this.durada = durada;
	}


	public ArrayList<Alumne> getListaAlumnes() {
		return listaAlumnes;
	}

	public void setListaAlumnes(ArrayList<Alumne> listaAlumnes) {
		this.listaAlumnes = listaAlumnes;
	}
	
	
	
	public void leer(Node nodoAsignatura) {
		
		System.out.println("Nodo 0 de asignatura: " + nodoAsignatura.getChildNodes().item(0).getTextContent());
		
		
	}
	

	public void addAlumnes() {
		
		Scanner sc = new Scanner(System.in);
		boolean salir = false;
		int contador = 0;
		
		while (!salir) {
			
			System.out.print("Introduce el nombre del alumno (introduzca 0 para salir): ");
			
			if (sc.hasNextInt()) {
				
				if (contador > 0 && sc.nextInt() == 0) { //Comprobamos que al menos se haya introducido un alumno
					
					salir = true;
					
				} else {
					System.out.println("Valor no válido");
				}
				
			} else {
				
				String nombre = sc.nextLine();	
				
				
				System.out.print("Introduzca el DNI: ");
				String dni = sc.nextLine();
				if (contador > 0) {
					
					sc.nextLine();					
					
				}
				
				
				System.out.print("Es repetidor? (use 0 para no, y 1 para si): ");
				
				if (sc.hasNextInt()) {
					
					int opcion = sc.nextInt();
					boolean repetidor = false; //Por defecto no es repetido
					
					if(opcion == 0 || opcion == 1) {
						
						if(opcion == 1){
							
							repetidor = true;
							
						}
						
						this.listaAlumnes.add(new Alumne(nombre, dni, repetidor));
						
					} else {
						
						System.out.println("Error no se ha introducido 0 o 1");
					}
					
					
				} else {
					System.out.println("Error no se ha introducido 0 o 1");
				}
				
				
			}
			
			contador++;
			
		}
		
		
		
		
		
	}
	
	
	public void guardarXML(Element nodoAsignaturas, Document doc){
		
		Element nodoAsignatura = doc.createElement("asignatura");
		nodoAsignaturas.appendChild(nodoAsignatura);//Insertamos la asignatura
		
		Element nodoNumero = doc.createElement("numero");
		nodoNumero.setTextContent(this.getNumero() + "");
		nodoAsignatura.appendChild(nodoNumero);
		
		Element nodoNombre = doc.createElement("nom");
		nodoNombre.setTextContent(this.getNom());
		nodoAsignatura.appendChild(nodoNombre);
		
		Element nodoDurada = doc.createElement("durada");
		nodoDurada.setTextContent(this.durada + "");
		nodoAsignatura.appendChild(nodoDurada);
		
		
		Element nodoAlumnos = doc.createElement("alumnos");
		nodoAsignatura.appendChild(nodoAlumnos);
        
        for (Alumne alumne : this.listaAlumnes) {
			
        	alumne.guardarXML(nodoAlumnos, doc);
        	
		}
		
		
	}
	
	
	
	
	public void imprimir() {
		
		System.out.println("\nAsignatura " + this.numero);
		System.out.println("-Nombre: " + this.nom);
		System.out.println("-Duración: " + this.durada + "\n");
		
		if (this.listaAlumnes.size() > 0) {
			
			System.out.println("-Lista de alumnos: \n");
			for (Alumne alumne : listaAlumnes) {
				
				alumne.imprimir();
				
			}
		}
		
		
		
	}
	
	

}
