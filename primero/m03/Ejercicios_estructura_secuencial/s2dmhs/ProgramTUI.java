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
    static String s2dhms(long s) {
        
        long dia = s/86400; //divide el valor de tiempo entre 86400
        long hor=(s -(86400*dia))/3600;
        long min=(s-(86400*dia) + (3600*hor))/60;
        long seg=s-((86400*dia) + (hor*3600)+(min*60));

        return ( s + "segons equivalen a " + dia + "d, " + hor + "h, " + min + "m, " + seg + "s");
    }

    /**
     * Modelizes the UI as a TUI.
     * 
     * @param args not used.
     */
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        long segundos;
        
        System.out.print("Introduce un número de segundos: ");
        segundos = teclado.nextLong();

        System.out.println(s2dhms(segundos));
    }
}
