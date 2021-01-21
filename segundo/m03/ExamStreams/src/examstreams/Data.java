/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examstreams;

/**
 *
 * @author ronald
 */
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
