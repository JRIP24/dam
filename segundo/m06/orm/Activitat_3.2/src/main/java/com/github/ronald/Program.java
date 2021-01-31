package com.github.ronald;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Level;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class Program {

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

    // Return date in sql format
    /*
    public static Date setDate(String strDate){
        LocalDate date = LocalDate.parse(strDate);
        return Date.valueOf(date);
    }*/
    
    public static void main(String[] args) {
        //Para no mostrar el log entero
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.WARNING);

        List<Client> clientes= new ArrayList<>();
        boolean salir = false;
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
        //Session session = sessionFactory.openSession();


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
                        Client client1 = new Client();
                        clientes = client1.getAllClients(sessionFactory);
                        client1 = client1.selectClient(clientes);

                        if(client1.getNom() != null){
                            client1.deleteClient(sessionFactory);
                        }

                        pausar();
                        break;


                    case 2:

                        System.out.println("Opcion 2");
                        Client client2 = new Client();
                        clientes = client2.getAllClients(sessionFactory);
                        client2 = client2.selectClient(clientes);

                        if(client2.getNom() != null){
                            client2.updateData(sessionFactory);
                        }
                        pausar();
                        break;

                    case 3:

                        System.out.println("Opcion 3");
                        Client client3 = new Client();
                        client3.searchClient(sessionFactory);
                        pausar();
                        break;


                    case 4:

                        System.out.println("Opcion 4");
                        Client client = new Client(true);
                        client.insertCliente(sessionFactory);

                        pausar();
                        break;


                    case 5:

                        System.out.println("Opcion 5");
                        Client client5 = new Client();
                        clientes = client5.getAllClients(sessionFactory);
                        client5 = client5.selectClient(clientes);

                        if(client5.getNom() != null){
                            Comanda comanda = new Comanda( true, client5);
                            comanda.insertComanda(sessionFactory);
                        }
                        pausar();
                        break;


                    case 6:
                        System.out.println("Opcion 6");
                        Client client6 = new Client();
                        clientes = client6.getAllClients(sessionFactory);
                        client6 = client6.selectClient(clientes);

                        if(client6.getNom() != null){
                            client6.listComandas();
                        }
                        pausar();
                        break;

                    case 7:
                        System.out.println("Opcion 7");
                        Client client7 = new Client();
                        clientes = client7.getAllClients(sessionFactory);
                        for (Client cliente : clientes ) {
                            cliente.resumFacturacio(sessionFactory);
                        }

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


        //Fin de bucle
        sessionFactory.close();
        StandardServiceRegistryBuilder.destroy(serviceRegistry);

    }




/*
        //List Client
        List<Client> clients= new ArrayList<>();

        //Create client object
        Client client1 = new Client(12341334, "TestHibernate1", true);
        Client client2 = new Client(12341335, "TestHibernate2", false);
        Client client3 = new Client(12341336, "TestHibernate3", true);

        Comanda comanda1 = new Comanda(12345, 19.00, setDate("2020-03-19"), client1.getDni());
        Comanda comanda2 = new Comanda(12346, 29.00, setDate("2020-03-19"), client1.getDni());
        Comanda comanda3 = new Comanda(12347, 19.00, setDate("2020-03-19"), client2.getDni());
        Comanda comanda4 = new Comanda(12348, 29.00, setDate("2020-03-19"), client3.getDni());
        Comanda comanda5 = new Comanda(12349, 19.00, setDate("2020-03-19"), client2.getDni());
        Comanda comanda6 = new Comanda(12350, 29.00, setDate("2020-03-19"), client2.getDni());
        Comanda comanda7 = new Comanda(12351, 19.00, setDate("2020-03-19"), client3.getDni());
        Comanda comanda8 = new Comanda(12352, 29.00, setDate("2020-03-19"), client2.getDni());

        client1.comandes.add(comanda1);
        client1.comandes.add(comanda2);
        client2.comandes.add(comanda3);
        client2.comandes.add(comanda5);
        client2.comandes.add(comanda6);
        client2.comandes.add(comanda8);
        client3.comandes.add(comanda4);
        client3.comandes.add(comanda7);

        //Create session with database
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();

        //Read all clients from database and save in list.
        clients.addAll(Client.readFromDataBase(sessionFactory));


        int exit = menu();
        while (exit != 0){
            switch (exit){
                case 1:
                    Client c1 = returnClientSelected(clients);
                    c1.delete(sessionFactory);
                    break;
                case 2:
                    Client c2 = returnClientSelected(clients);
                    c2.update(sessionFactory);
                    break;
                case 3:
                    Client.findClientByName(sessionFactory);
                    break;
                case 4:
                    Client.add(sessionFactory, clients);
                    break;
                default:
                    System.err.println("This option does not exist!");
                    break;
            }
            exit = menu();
        }



        //saveClient(sessionFactory, client1);
        //deleteClient(sessionFactory, client1);
        //updateClient(sessionFactory, client1);
        //showClientWhoseNameBeginsWith(sessionFactory);
        //addComand(sessionFactory, clients);
        //addClient(sessionFactory, clients);
        //showClientComandes(clients);

        //String hql="SELECT dni_client ,sum(quantitat) FROM resum_facturacio res GROUP BY res.dni_client";

        sessionFactory.close();
        StandardServiceRegistryBuilder.destroy(serviceRegistry);

    }


    public static void deleteClient(SessionFactory factory, Client client){
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.createQuery("delete from Comanda where dni_client= :dni").setParameter("dni", client.getDni()).executeUpdate();
            session.delete(client);
            session.getTransaction().commit();
        }
    }

    public static void updateClient(SessionFactory factory, Client client){

        System.out.println("Enter the new name: ");
        String name = getScanner().next();

        System.out.println("Is it premium? (s/n): ");
        Boolean premium = getScanner().next().equalsIgnoreCase("S");

        try(Session session = factory.openSession()){
            session.beginTransaction();
            Client c = session.createQuery("from Client c where c.dni=:id", Client.class).setParameter("id", 11111112).getSingleResult();
            c.setNom(name);
            c.setPremium(premium);
            session.update(c);
            session.getTransaction().commit();
        }
    }

    public static Client getClient(SessionFactory factory, Client client){
        Client c = new Client();
        try(Session session = factory.openSession()){
            session.beginTransaction();
            c = session.createQuery("from Client c where c.dni=:id", Client.class).setParameter("id", 11111112).getSingleResult();
            System.out.println(c.getDni() + "\n"+ c.getNom());
            session.getTransaction().commit();
        }
        return c;
    }

    public static void showClientWhoseNameBeginsWith(SessionFactory factory){
        String letters = "Jo";
        try(Session session = factory.openSession()){
            session.beginTransaction();
            List<Client> cli = session.createQuery("from Client where nom LIKE Concat('"+letters+"','%')").getResultList();
            Iterator it = cli.iterator();
            while (it.hasNext()) {
                Client emp = (Client) it.next();
                System.out.println(emp.getNom());
            }
        }
    }

    public static List<Client> readClient(SessionFactory factory){
        try(Session session = factory.openSession()){
            session.beginTransaction();
            return session.createQuery("from Client").getResultList();
        }
    }

    public static void addClient(SessionFactory factory, List<Client> clients){

        System.out.println("Enter a dni: ");
        int dni = getScanner().nextInt();

        System.out.println("Enter a name: ");
        String name = getScanner().next();

        System.out.println("Is it premium? (s/n): ");
        Boolean premium = getScanner().next().equalsIgnoreCase("S");

        Client clientTmp = new Client(dni, name, premium);

        //System.out.println(clients.contains(clientTmp));


        if (!clients.contains(clientTmp)){
            try(Session session = factory.openSession()){
                session.beginTransaction();
                session.save(clientTmp);
                session.getTransaction().commit();
            }catch (Exception e){
                e.getStackTrace();
            }
        } else {
            System.err.println("The client already exists!");
        }
    }

    public static void addComand(SessionFactory factory,List<Client> clients){
        Client client = returnClientSelected(clients);
        Comanda comandaTmp = createComand(client);

        if (!client.comandes.contains(comandaTmp)){
            try(Session session = factory.openSession()){
                session.beginTransaction();
                session.save(comandaTmp);
                session.getTransaction().commit();
            }
            client.comandes.add(comandaTmp);
        } else {
            System.out.println("The comanda already exists!");
        }
    }

    public static Comanda createComand(Client c){

        System.out.println("Enter a order id: ");
        int dni = getScanner().nextInt();

        System.out.println("Enter order price: ");
        Double preu = getScanner().nextDouble();

        System.out.println("Enter a order date (format: yyyy-MM-dd): ");
        Date date = setDate(getScanner().next());

        return new Comanda(dni, preu, date, c.getDni());
    }



    public static Client returnClientSelected(List<Client> clients){

        //Show all clients
        int cont = 1;
        for (Client c: clients) {
            System.out.println(cont+") "+c.getDni()+"\t"+c.getNom());
            cont++;
        }
        System.out.println();

        System.out.print("Select the client: ");
        int optionSelected = getScanner().nextInt();

        if ((optionSelected != 0) && (optionSelected < cont)){
            //Return client selected
            cont = 1;
            for (Client c: clients) {
                if (optionSelected == cont){
                    return c;
                }
                cont++;
            }
        } else {
            System.err.println("This option does not exist!");
        }
        return new Client();
    }


    public static void showClientComandes(List<Client> clients){
        Client client = returnClientSelected(clients);
        System.out.println("Nom: "+client.getNom() + "\n" + "Dni: "+ client.getDni()+" :\n");
        for (Comanda c: client.comandes) {
            System.out.println("\tNum Comanda: "+ c.getNum_comanda());
            System.out.println("\tPreu Total: "+ c.getPreu_total());
            System.out.println("\tData: "+ c.getData()+"\n");
        }
    }



    //Extras
    public static void saveClient(SessionFactory factory, Client client){
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(client);
            for (Comanda c: client.comandes) {
                session.save(c);
            }
            session.getTransaction().commit();
        }
    }

    /*
    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory(){
        //Create session with database
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }*/


}