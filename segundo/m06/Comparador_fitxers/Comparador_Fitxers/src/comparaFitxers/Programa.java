package comparaFitxers;

import java.io.File;
import java.util.Scanner;

public class Programa {
	
	static boolean validDir(File dir) {
		
		return dir.exists() && dir.isDirectory();
	}
	
	static void compareDirs(File d1, File d2) {
		
		int d1Length = d1.list().length;
		
		if (d1Length <= 0) {
			
			System.out.println("El directorio " + d1 + " está vacío");
			
		} else {
	
			for(int i = 0; i < d1Length; i++) {
				System.out.println(d1.list()[i]);
			}
		}
		
	}
	
	
	

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		String ruta1;
		String ruta2;
		
		System.out.print("Ingrese la ruta ABSOLUTA del primer directorio: ");
		ruta1 = teclado.nextLine();
		
		
		File dir1 = new File(ruta1);
		
		if (!validDir(dir1)) {
			
			System.out.println("ERROR: El directorio " + ruta1 + " no es válido");
			
		} else {
			System.out.print("Ingrese la ruta ABSOLUTA del segundo directorio: ");
			ruta2 = teclado.nextLine();
			File dir2 = new File(ruta2);
			
			if(!validDir(dir2)) {
				
				System.out.println("ERROR: El directorio " + ruta2 + " no es válido");
				
			} else {//Podemos continuar
				System.out.println("Se puede");
				compareDirs(dir1, dir2);
				
			}
			
		}
		
		
		

	}

}
