/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activitat3.pkg2;

import java.io.Serializable;
import java.sql.Date;
import java.util.Scanner;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ronald
 */

@Entity
@Table(name="client")
public class Client implements Serializable{
    
    @Id
    String dni;
    String nom;
    boolean premium;
    
    public Client (boolean demanaTeclat) {
        if (demanaTeclat){
            Scanner teclat = new Scanner(System.in);      
            
            System.out.println("Introdueix el DNI:");
            this.dni = teclat.nextLine();
            
            System.out.println("Introdueix el nom:");
            this.nom = teclat.nextLine();
            
            boolean valorCorrecte = false;
            while (!valorCorrecte) { 
                System.out.println("Es premium? (S/N):");
                String valor = teclat.nextLine();
                if (valor.equals("S") || valor.equals("N")) {
                    
                    if (valor.equals("S")){
                        this.premium = true;
                    } else {
                        this.premium = false;
                    }
                    valorCorrecte = true;                    
                }
            }
        }
    }
    
    public Client(){
        
    }
    
}
