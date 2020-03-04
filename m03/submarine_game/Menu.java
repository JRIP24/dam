
/*Hacer
    -menu
    -control de erroes
    -juego
    -ayuda
*/

package submarine_game;

public class Menu{

    public static void main(String[] args){

        //Se muestra menu
        Submarine s = new Submarine("SUB");

        Player p = new Player("Ronald");

        System.out.println(p.cargas);
        System.out.println(s.nom);


    }


    
}