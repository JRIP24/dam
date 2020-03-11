package submarine_game;

import java.util.Scanner;


public class Player{

    Scanner teclado = new Scanner(System.in);
    
    int cargas = 0;
    int bombY = 0;
    int bombX = 0;

    //Disparo del jugador
    public void shot(){

        System.out.println("Ingrese las coordernadas en las que desea lanzar el misil");
        System.out.print("Coordenada X: ");
        this.bombX = teclado.nextInt();

        System.out.print("Coordenada Y: ");
        this.bombY = teclado.nextInt();

        System.out.println("Se lanzará el misil en las coordenadas (" + this.bombX + ", " + this.bombY + ")");

    }




}