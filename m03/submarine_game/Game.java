package submarine_game;

import java.util.Scanner;

public class Game{

    public static void main(String[] args){


        Scanner teclado = new Scanner(System.in);

        Sea mar = new Sea(5);
        System.out.println("Dimensión de mar: " + mar.size + "x" + mar.size);

        //Creación de submarino
        Submarine s = new Submarine();

        //Valor random entre n1 y n2 (n1 < n2), ambos incluidos
        //Math.floor(Math.random()*(n2-n1+1)+n1));

        s.cordX = (int)Math.floor(Math.random()*(mar.size-0+1)+0);
        s.cordY = (int)Math.floor(Math.random()*(mar.size-0+1)+0);


        //Inicializamos al jugador
        
        Player p = new Player();

        //Ponemos 5 misiles por defecto
        int misiles = 5;
                                                                                                                                                                                                                                                                                                                                                                                                                                                        
        p.cargas = misiles;

        //Inicia juego

        boolean salir = false;
        boolean tocado = false;
        boolean lose = false;
        boolean win = false;
        boolean alrededor = false;
        String resultado = "";

        while(salir == false){

            System.out.println("Coordenadas del submarino: (" + s.cordX + ", " + s.cordY + ")");

            System.out.println("Bombas restantes: " + p.cargas + " \n");
            
            //El jugador disparará
            p.shot();

            p.cargas--;

            //Comprobamos si ha tocado el submarino

            if(p.bombX == s.cordX && p.bombY == s.cordY){
                tocado = true;
                win = true;
                resultado = "HAS GANADO!!";
            }

            if (tocado == false && p.cargas == 0){
                lose = true;
                resultado = "DERROTA: SE HAN ACABADO LAS BOMBAS";
            }


            //Condición de salida del bucle
            if(win == true || lose == true){

                salir = true;

            } else {//Movemos el submarino

                s.move(mar.size);
            }

        }

        System.out.println(resultado);

    }
}
