import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jordi
 */
public class Ac3_1 {

    public static void insereixNouPolitic() {
        
        Politic p = new Politic(true);
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.save(p);
            session.getTransaction().commit();
        }
        finally {
            session.close();
            factory.close();
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
        }
    }
    
     public static void pintaPolitics() {
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
        Session session = factory.openSession();
        try {
            Query query= session.createQuery("from Politic");
            List<Politic> lstPolitics = query.list();
            for (Politic p : lstPolitics) {
                 System.out.println(p);
            }
        }
        finally {
            session.close();
            factory.close();
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
        }
     }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        insereixNouPolitic();
        //pintaPolitics();
    }
    
}
