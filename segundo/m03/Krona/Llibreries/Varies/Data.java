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
	
	       

}
