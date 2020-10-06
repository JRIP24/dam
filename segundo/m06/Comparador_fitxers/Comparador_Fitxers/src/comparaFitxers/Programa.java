package comparaFitxers;

import java.io.File;
import java.util.Scanner;

public class Programa {
	
	static boolean validDir(File dir) {
		
		return dir.exists() && dir.isDirectory();
	}
	
	static String checkDates(File f1, File f2) {
		
		long datef1 =  f1.lastModified();
		long datef2 =  f2.lastModified();
		String mensaje = "";
		
		if (datef1 > datef2) {//f1 es más reciente
			
			mensaje = "El fitxer al directori A és més nou que a B";
					
		} else if (datef2 > datef1) {
			
			mensaje = "El fitxer al directori B és més nou que a A";
			
		} else {
			mensaje = "Tenen la mateixa mida";
		}
		
		return mensaje;
		
	}
	
	static String checkSizes(File f1, File f2) {
		
		String mensaje = "";
		long sizef1 = f1.length();
		long sizef2 = f2.length();
		
		if (sizef1 > sizef2) {//f1 es más reciente
			
			mensaje = "El fitxer al directori A és més gran que a B";
					
		} else if (sizef2 > sizef1) {
			
			mensaje = "El fitxer al directori B és més gran que a A";
			
		} else {
			mensaje = "Tenen la mateixa mida";
		}
		
		
		return mensaje;
	}
	
	static void compareDirs(File d1, File d2) {
		
		int d1Length = d1.list().length;
		
		if (d1Length <= 0) {
			
			System.out.println("El directorio " + d1 + " está vacío");
			
		} else {
	
			for(int i = 0; i < d1Length; i++) {
				String archivo = d1.list()[i];
				File archivoPath = new File (d1 + "/" +  archivo);
				
				
				if(!validDir(archivoPath)) {//Comprobamos que sea un archivo
					
					for (int x = 0; x < d2.list().length; x++) {
						String file = d2.list()[x];
						File filePath = new File(d2 + "/" + file);
						
						if (!validDir(filePath)) {
							if (file.equals(archivo)) {
								
								System.out.println("El fitxer '" +  archivo + "' existeix a ambdós directoris");
								
								System.out.println("--------" + checkDates(archivoPath, filePath));
								System.out.println("--------" + checkSizes(archivoPath, filePath));
								

							} else {
								System.out.println("El fitxer '" +  archivo + "' existeix al directori A, però no existeix al directori B");
							}
						}
						
						
					}
					
				}
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
				compareDirs(dir1, dir2);
				
			}
			
		}
		
		
		

	}

}
