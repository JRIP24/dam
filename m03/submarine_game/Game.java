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

        int randomX = (int)Math.floor(Math.random()*(mar.size-0+1)+0);
        int randomY = (int)Math.floor(Math.random()*(mar.size-0+1)+0);
        s.setCordX(randomX); 
        s.setCordY(randomY);


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
        String resultado = "";

        while(salir == false){

            System.out.println("Coordenadas del submarino: (" + s.getCordX() + ", " + s.getCordY() + ")");

            System.out.println("Bombas restantes: " + p.cargas + " \n");
            
            //El jugador disparará
            p.shot();

            p.cargas--;

            //Comprobamos si ha tocado el submarino

            if(p.bombX == s.getCordX() && p.bombY == s.getCordY()){
                tocado = true;
                win = true;
                resultado = "HAS GANADO!!";
            }

            //Comprobamos si ha tocado los alrededores
            if (tocado == false){

                boolean exitRound = false;
                int counter = 0;
                boolean around = false;

                while(exitRound == false){

                    System.out.println("X: " + s.aroundX[counter]);
                    System.out.println("Y: " + s.aroundY[counter]);
                    System.out.println("-------------------------");


                    if (p.bombX == s.aroundX[counter] && p.bombY == s.aroundY[counter]){
                        around = true;
                    }

                    //incremento
                    counter++;

                    if (around == true || counter >= s.aroundX.length){
                        exitRound = true;
                    }

                }//fin de bucle

                if (around == true){
                    System.out.println("Ha estado cerca!!");
                    System.out.println("Coordenadas del submarino: (" + s.getCordX() + ", " + s.getCordY() + ")");
                }

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
