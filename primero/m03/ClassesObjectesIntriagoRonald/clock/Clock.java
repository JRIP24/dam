package clock;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Clock {

    Date d = new Date();
    Calendar c = new GregorianCalendar();
    
    public void show(){

        boolean salir = false;
        String dia, mes, annio, hora, minuto, segundo;

        dia = Integer.toString(c.get(Calendar.DATE));
        mes = Integer.toString(c.get(Calendar.MONTH));
        annio = Integer.toString(c.get(Calendar.YEAR));
        hora = Integer.toString(c.get(Calendar.HOUR_OF_DAY));
        minuto = Integer.toString(c.get(Calendar.MINUTE));
        segundo = Integer.toString(c.get(Calendar.SECOND));

        System.out.println("");
        System.out.println("------------------");
        System.out.println (dia + "/" + mes +"/" + annio + "-" + hora + ":" + minuto + ":" + segundo );
        System.out.println("------------------");
        System.out.println("");
    
        
    }

    public static void main(String[] args){

        Clock reloj = new Clock();
        reloj.show();

    }

}