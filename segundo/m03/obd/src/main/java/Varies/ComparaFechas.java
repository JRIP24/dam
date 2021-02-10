package Varies;

import java.text.Collator;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Locale;


public class ComparaFechas {
	
	
	public int comparar(LocalDateTime fecha1, LocalDateTime fecha2) {
		
		int result = 0;
		

		Collator comparador = Collator.getInstance();
		comparador.setStrength(Collator.PRIMARY);
		result = comparador.compare(fecha1, fecha2);
		
		return result;
		
	}
	

}
