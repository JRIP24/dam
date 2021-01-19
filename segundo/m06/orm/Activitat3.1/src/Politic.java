/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ronald
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;



public class Politic {
    
    String nif;
    String nom;
    LocalDate dataNaixement;
    int sou;
    boolean esCorrupte;
    
    @Override
    public String toString () {
        String sortida = "NIF: "+ this.nif+"\n";
        sortida += "nom: "+ this.nom + "\n";
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
        sortida += "data naixement: " + this.dataNaixement.format(DateTimeFormatter.ofPattern("d/MM/yyyy")) +"\n";
        sortida += "sou: "+this.sou+"\n";
        sortida += "és corrupte?: " + ((this.esCorrupte) ? "Sí" : "No") +"\n";
        return sortida;
    }
    
    
    public Politic (boolean demanaTeclat) {
        if (demanaTeclat)
        {
            Scanner teclat = new Scanner(System.in);      
            
            System.out.println("Introdueix el NIF:");
            this.nif = teclat.nextLine();
            
            System.out.println("Introdueix el nom:");
            this.nom = teclat.nextLine();
            
            boolean dataCorrecta = false;
            while (!dataCorrecta) {
                System.out.println("Introdueix la data de naixement (dia/mes/any):");
                String data = teclat.nextLine();                
                this.dataNaixement = LocalDate.parse(data, DateTimeFormatter.ofPattern("d/MM/yyyy"));
                dataCorrecta = true;
            }
            
            System.out.println("Introdueix el sou:");
            this.sou = teclat.nextInt();
            
            boolean valorCorrecte = false;
            while (!valorCorrecte) { 
                System.out.println("Introdueix si és corrupte (S/N):");
                String valor = teclat.nextLine();
                if (valor.equals("S") || valor.equals("N")) {
                    this.esCorrupte = valor.equals("S");
                    valorCorrecte = true;                    
                }
            }
        }
    }

    
    
}
