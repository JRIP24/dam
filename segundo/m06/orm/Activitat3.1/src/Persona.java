/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.*;

/**
 *
 * @author ronald
 */
@Entity
@Table (name="bd_persona") // nombre de la tabla en la BBDD
public class Persona {
    
    @Id //identificador (PK)
    public int id;
    
    public Persona(int idP){
        this.id = idP;
        
    }
    
}
