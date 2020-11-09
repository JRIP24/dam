import java.util.ArrayList;
import java.util.Scanner;

public class Assignatura {
	
	private int numero;
	private String nom;
	private int durada;
	private ArrayList<Alumne> listaAlumnes;
	
	
	
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
	
	
	public void addAlumnes() {
		
		Scanner sc = new Scanner(System.in);
		boolean salir = false;
		int contador = 0;
		
		while (!salir) {
			
			System.out.print("Introduce el nombre del alumno (introduzca 0 para salir): ");
			
			if(sc.hasNextInt()) {
				
				if (sc.nextInt() == 0) {
					
					if (contador > 0) { //Comprobamos que al menos se haya introducido un alumno
						
						salir = true;
						
					} else {
						System.out.println("Valor no válido");
					}
					
				} else {
					System.out.println("Valor no válido");
				}
			}
			
			if (sc.hasNextLine()) {
				
				String nombre = sc.nextLine();
				
				System.out.print("Introduzca el DNI: ");
				String dni = sc.nextLine();
				
				
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
			
			
			
		}
		
		
		
		
		
	}
	
	
	
	
	public void imprimir() {
		
		System.out.println("\n Asignatura " + this.numero);
		System.out.println("-Nombre: " + this.nom);
		System.out.println("-Duración: " + this.durada);
		
		if (this.listaAlumnes.size() > 0) {
			
			System.out.println("Lista de alumnos");
			for (Alumne alumne : listaAlumnes) {
				
				alumne.imprimir();
				
			}
		}
		
		
		
	}
	
	

}
