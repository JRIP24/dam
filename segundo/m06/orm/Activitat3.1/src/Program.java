/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author ronald
 */
public class Program {
    
    public static void main (String[] args){
        
        /*Guardar en BBDD
        Persona p = new Persona(34);
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new
        StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.save(p);
            session.getTransaction().commit();
            
        }finally{
            System.out.println("Entra aqui");
            session.close();
            factory.close();
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
            
        }*/
        
        
        //Recuperar por ID
        /*
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new
        StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
        Session session = factory.openSession();
        try{
            
            Persona p = (Persona) session.get(Persona.class, 1);
            System.out.println(p.id);
            
        } finally{
            
            session.close();
            factory.close();
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
            
        }*/
        
        
        //Recuperar Query
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new
        StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
        Session session = factory.openSession();
        try{
            
            Query query = session.createQuery("from Persona where id = 33"); // from + el nom de la classe !!!
            List<Persona> lstPersones = query.list();
            Persona p = lstPersones.get(0);
            System.out.println(p.id);
            
        } finally{
            
            session.close();
            factory.close();
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
            
        }
        
        
        
    }
    
}
