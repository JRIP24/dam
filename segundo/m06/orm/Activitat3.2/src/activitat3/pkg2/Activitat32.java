/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activitat3.pkg2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ronald
 */
public class Activitat32 {
    /**
     * @param args the command line arguments
     */
    
    
    
    public static void pausar(){
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while(!exit) {

            System.out.println("Presione 'Enter' para continuar");
                String readString = scanner.nextLine();

            if (readString.isEmpty()) {
                    System.out.println("\n \n");

                exit = true;

            }
        }

    }
    
    
    public static void main(String[] args) {
        
        boolean salir = false;


        while (!salir) {

                Scanner teclado = new Scanner(System.in); 

                System.out.println("*************************");
                System.out.println("*                       *");
                System.out.println("*     ACTIVIDAD 3.2     *");
                System.out.println("*                       *");
                System.out.println("************************* \n");

                System.out.println("0 - Salir");
                System.out.println("1 - Eliminació d'un client.");
                System.out.println("2 - Actualització de les dades d'un client.");
                System.out.println("3 - Cerca per nom de client");
                System.out.println("4 - Alta d'un nou client");
                System.out.println("5 - Alta d'una nova comanda");
                System.out.println("6 - Mostrar per pantalla les comandes d'un client");
                System.out.println("7 - Mostrar per pantalla un resum de tots els clients amb la quantitat total que han facturat, ordenat de més facturació a menys facturació \n \n");

                System.out.print("Introduzca una opción: ");

                if (teclado.hasNextInt()) {

                        int opcion = teclado.nextInt();

                        switch (opcion) {
                        case 0:

                                System.out.println("Saliendo...");
                                salir = true;

                                break;

                        case 1:

                                System.out.println("Opcion 1");
                                
                                pausar();
                                break;


                        case 2:

                                System.out.println("Opcion 2");
                                
                                pausar();
                                break;

                        case 3:

                                System.out.println("Opcion 3");

                                pausar();
                                break;


                        case 4:

                                System.out.println("Opcion 4");
                                DatabaseCon.insertCliente();
                                pausar();
                                break;


                        case 5:

                                System.out.println("Opcion 5");

                                pausar();
                                break;



                        case 6:
                                System.out.println("Opcion 6");
                                
                                pausar();
                                break;
                                
                        case 7:
                                System.out.println("Opcion 7");
                                
                                pausar();
                                break;



                        default:

                                System.out.println("Error: se debe introducir un número del 0 al 7");
                                pausar();

                                break;
                        }



                } else {

                        System.out.println("Error: No se ha introducido ningún número");
                        pausar();

                }






        }


    }
    
}
