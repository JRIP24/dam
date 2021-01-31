package com.github.ronald;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity
@Table(name = "client")
public class Client implements Serializable {

    @Id
    private int dni;
    private String nom;
    private Boolean premium;


    //@OneToMany
    //@JoinColumn(name = "dni_client")
    @OneToMany(mappedBy = "dni_client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<Comanda> comandes = new HashSet<>();

    public Client() {
    }

    public Client(int dniP, String nomP, boolean premiumP){
        this.setDni(dniP);
        this.setNom(nomP);
        this.setPremium(premiumP);
    }


    public Client (boolean demanaTeclat) {
        if (demanaTeclat){
            Scanner teclat = new Scanner(System.in);
            System.out.println("Introdueix el DNI (sin letra):");
            this.setDni(teclat.nextInt());

            System.out.println("Introdueix el nom:");
            teclat.nextLine();
            this.setNom(teclat.nextLine());

            boolean valorCorrecte = false;
            while (!valorCorrecte) {
                System.out.println("Es premium? (S/N):");
                String valor = teclat.nextLine();
                if (valor.equals("S") || valor.equals("N")) {

                    if (valor.equals("S")){
                        this.setPremium(true);
                    } else {
                        this.setPremium(false);
                    }
                    valorCorrecte = true;
                }
            }
        }
    }

    void insertCliente(Client client, Session session){

        try {
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
        } catch(Exception e){
            System.out.println("Error:" + e);

        }

    }


    static List<Client> getAllClients(Session session){
        session.beginTransaction();
        return session.createQuery("from Client").getResultList();
    }

    static Client selectClient(List<Client> clientes){

        Scanner teclado = new Scanner(System.in);
        int numCliente;
        Client selectedClient = new Client();

        for (Client client: clientes) {
            System.out.println(clientes.indexOf(client) + " - " + client.getNom() + ", dni -> " + client.getDni());
        }

        System.out.print("Inserte el número del cliente que quiere seleccionar: ");
        numCliente = teclado.nextInt();

        if (numCliente < clientes.size()){

            selectedClient = clientes.get(numCliente);

        } else {
            System.out.println("Error, el número seleccionado no está en la lista de clientes");
        }

        return selectedClient;
    }

    public void deleteClient(SessionFactory factory) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Comanda where dni_client= :dni").setParameter("dni", getDni()).executeUpdate();
            session.delete(this);
            session.getTransaction().commit();
        }
    }







    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Boolean getPremium() {
        return premium;
    }

    public void setPremium(Boolean premium) {
        this.premium = premium;
    }

    public Set<Comanda> getComandes() {
        return comandes;
    }

    public void setComandes(Set<Comanda> comandes) {
        this.comandes = comandes;
    }

    /*

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return dni == client.dni;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    public static List<Client> readFromDataBase(SessionFactory factory){
        try(Session session = factory.openSession()){
            session.beginTransaction();
            return session.createQuery("from Client").getResultList();
        }
    }


    public void delete(SessionFactory factory) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Comanda where dni_client= :dni").setParameter("dni", getDni()).executeUpdate();
            session.delete(this);
            session.getTransaction().commit();
        }
        System.out.println("Client Successfully Deleted.");
    }

    public void update(SessionFactory factory) {

        System.out.print("Enter the new name: ");
        String name = Program.getScanner().next();

        System.out.print("Is it premium? (s/n): ");
        Boolean premium = Program.getScanner().next().equalsIgnoreCase("S");

        try (Session session = factory.openSession()) {
            session.beginTransaction();
            //Client c = session.createQuery("from Client c where c.dni=:id", Client.class).setParameter("id", getDni()).getSingleResult();
            setNom(name);
            setPremium(premium);
            session.update(this);
            session.getTransaction().commit();
        }
        System.out.println("Client Successfully Updated.");
    }

    public static void findClientByName(SessionFactory factory) {
        System.out.print("Find client whose name begins with: ");
        String letters = Program.getScanner().next();

        try (Session session = factory.openSession()) {
            session.beginTransaction();
            List<Client> cli = session.createQuery("from Client where nom LIKE Concat('" + letters + "','%')").getResultList();
            Iterator it = cli.iterator();
            while (it.hasNext()) {
                Client emp = (Client) it.next();
                System.out.println(emp.getNom());
            }
        }
    }


    public static void add(SessionFactory factory, List<Client> clients){

        System.out.print("Enter a dni: ");
        int dni = Program.getScanner().nextInt();
        System.out.print("Enter a name: ");
        String name = Program.getScanner().next();
        System.out.print("Is it premium? (s/n): ");
        Boolean premium = Program.getScanner().next().equalsIgnoreCase("S");

        Client clientTmp = new Client(dni, name, premium);

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
    }*/

}
