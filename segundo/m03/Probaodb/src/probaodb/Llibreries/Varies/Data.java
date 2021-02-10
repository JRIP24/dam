package Varies;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Data {
	
	public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
	
	public static String imprimirData(LocalDateTime dataTmp) {
		
		String formattedDateTime = "NULL";
		
		if (dataTmp != null) {
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
			
			formattedDateTime = dataTmp.format(formatter);			
		}
		
			
		return formattedDateTime;
	}
	
	
	public static boolean esData(String dataTmp) {
		
		boolean resultado = false;
		
		if (dataTmp.split("-").length == 3) {
			
			int contador = 0;
			
			for (String parte : dataTmp.split("-")) {
				
				if (Cadena.stringIsInt(parte)) {
					
					contador++;
					
				}
				
			}
			
			
			if (contador == 3) {
				resultado = true;				
				
			} else {
				resultado = false;
			}
			
		}
		
		return resultado;
		
	}
	
	
	       

}
