import java.util.Scanner;

package submarine_game;

public class Game{

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        Sea mar = new Sea(5);
        System.out.println("Dimenssión de mar: " + mar.sizeX + "x" + mar.sizeY);

        //Creación de submarino
        Submarine s = new Submarine();

        //Valor random entre n1 y n2 (n1 < n2), ambos incluidos
        //Math.floor(Math.random()*(n2-n1+1)+n1));

        s.cordX = (int)Math.floor(Math.random()*(mar.sizeX-0+1)+0);
        s.cordY = (int)Math.floor(Math.random()*(mar.sizeY-0+1)+0);
        
        Player p = new Player("Ronald");
        
        System.out.println("Hola " + p.name);
        
        int misiles = 6;
                                                                                                                                                                                                                                                                                                                                                                                                                                                        
        p.cargas = misiles;

        System.out.println("Tienes " + p.cargas + " cargas");

        //Inicia juego
/*
        boolean salir = false;
        boolean tocado = false;
        boolean ganado = false;
        boolean alrededor = false;
        boolean hay_cargas = true;

        while(salir == false){

            System.out.println("Ingrese las coordernadas en las que desea lanzar el misil");
            System.out.println("Coordenada X: ");
            p.cordX = teclado.nextInt();

            System.out.println("Coordenada Y: ");
            p.cordY = teclado.nextInt();

            System.out.println("Se lanzará el misil en las coordenadas " + "( " + p.cordX + ", " + p.cordY + " )");






            //Condición de salida del bucle
            if(){
                salir = true;
            }

        }*/






    }
}
