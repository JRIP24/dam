/*
 * ProgramTUI.java        VERSION DATE
 *
 * Models the program.
 *
 * Copyright YEAR FULL_NAME <EMAIL>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

import java.util.Scanner;
import java.util.Locale;

public class ProgramTUI {

    /**
     * Convert a number of seconds into days, hours, minutes and seconds.
     * 
     * @param s a number of seconds.
     * @return a string with the format
     *         "s segons seran d dies, h hores, m minuts i rs segons."
     */
    public String s2dhms(long s) {
        
        int hor=s/3600;
        int min=(s-(3600*hor))/60;
        int seg=s-((hor*3600)+(min*60));

        return ( s + "segundos equivalen a " + hor + "h, " + min + "m, " + seg + "s");
    }

    /**
     * Modelizes the UI as a TUI.
     * 
     * @param args not used.
     */
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int segundos;
        
        System.out.print("Introduce un número de segundos: ");
        segundos = teclado.nextInt();

        System.out.println(s2dhms(segundos));
    }
}
