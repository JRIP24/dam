
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

        Sea mar = new Sea(5,5);
        System.out.println("Dimenssión de mar: " + mar.sizeX + "x" + mar.sizeY);

        //Creación de submarino
        Submarine s = new Submarine();
        // s.cordX = random
        // s.cordY = random
        
        Player p = new Player("Ronald");
        
        System.out.println("Hola " + p.name);
        
        int misiles = 6;

        p.cargas = misiles;

        System.out.println("Tienes " + p.cargas + " cargas");








    }


    
}