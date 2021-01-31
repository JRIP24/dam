/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activitat3.pkg2;

/**
 *
 * @author ronald
 */

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public abstract class DatabaseCon {
    
    public static void insertCliente(){
        
        Client cliente = new Client(true);
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.save(cliente);
            session.getTransaction().commit();
        } catch(Exception e){
            
            System.out.println(e);
            
        }finally {
            session.close();
            factory.close();
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
        }
        
    }
    
    
    
}
