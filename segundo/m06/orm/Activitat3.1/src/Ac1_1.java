import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jordi
 */
public class Ac1_1 {
  
     public static int menu() {
        System.out.println("Seleccioneu una opció:"
                + "\n 0.- Sortir"
                + "\n 1.- Crear taula"
                + "\n 2.- Inserir un polític"
                + "\n 3.- Llegir polítics");
        
        Scanner teclat = new Scanner(System.in);      
        return teclat.nextInt(); // TODO comprovar que el número és correcte
    }
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
                  
         try (PoliticBBDD bbdd = new PoliticBBDD();)
         {            
            Politic p;
            int opcio = menu();
            while (opcio != 0) {
                switch (opcio) {
                    case 1:
                        bbdd.creaTaula();
                        break;
                    case 2:
                        p = new Politic(true);
                        System.out.println(p);
                        bbdd.insereix(p);
                        break;
                    case 3:
                        List<Politic> llistaPolitics = bbdd.selecciona();
                        System.out.println("=== LLISTA DE POLÍTICS ====");
                        for (Politic pi : llistaPolitics) {
                            System.out.println(pi);
                        }
                        System.out.println("===========================");
                        break;
                }

                opcio = menu();
            }
         }
         
    }
    
}