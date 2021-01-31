/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activitat3.pkg2;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ronald
 */
@Entity
@Table(name="comanda")
public class Comanda{
    @Id
    int num_comanda;
    double preu_total;
    Date data;
    String dni_client;
    
}
