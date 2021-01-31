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

    void insertCliente(SessionFactory factory){

        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.save(this);
            session.getTransaction().commit();
        } catch(Exception e){
            System.out.println("Error:" + e);

        }finally {
            session.close();
        }

    }


    static List<Client> getAllClients(SessionFactory factory){
        Session session = factory.openSession();
        List<Client> clients = new ArrayList<Client>();
        try {
            session.beginTransaction();
            clients = session.createQuery("from Client").getResultList();
        } catch (Exception e){

        } finally {
            session.close();
        }

        return clients;
    }

    static Client selectClient(List<Client> clientes){

        Scanner teclado = new Scanner(System.in);
        int numCliente;
        Client selectedClient = new Client();

        for (Client client: clientes) {
            System.out.println(clientes.indexOf(client) + ") " + client.getDni() + " - " + client.getNom());
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

    void deleteClient(SessionFactory factory) {
        Session session = factory.openSession();
        try  {
            session.beginTransaction();
            session.createQuery("delete from Comanda where dni_client= :dni").setParameter("dni", getDni()).executeUpdate();
            session.delete(this);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();

        }finally {
            session.close();
        }
    }

    void updateData(SessionFactory factory) {
        Scanner teclat = new Scanner(System.in);

        System.out.println("Introdueix el nom:");
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
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(this);
            session.getTransaction().commit();
        } catch (Exception e){

            System.out.println("Error: " + e.getMessage());

        }finally {
            session.close();
        }
    }

    static void searchClient(SessionFactory factory) {
        String texto = "";
        Scanner teclado = new Scanner(System.in);
        System.out.print("Intoduzca el nombre del cliente: ");
        texto = teclado.nextLine();

        Session session = factory.openSession();
        try {
            session.beginTransaction();
            List<Client> clientes = session.createQuery("from Client where nom LIKE Concat('" + texto + "','%')").getResultList();
            if (clientes.size() == 0){
                System.out.println("No se han encontrado clientes \n");
            } else {

                System.out.println("Resultados de búsqueda: \n");
                for (Client cliente : clientes ){
                    System.out.println(" - " + cliente.getNom() + ", dni: " + cliente.getDni() + ", premium?: " + cliente.getPremium());
                }
                System.out.println("\n");
            }



        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        } finally {
            session.close();
        }
    }


    void listComandas() {
        System.out.println("Comandes de: " + this.getNom());
        for (Comanda comanda : this.comandes) {
            System.out.println("-Num: " + comanda.getNum_comanda() + "\n" +
                    "Data: " + comanda.getData() + "\n" +
                    "Preu total: " + comanda.getPreu_total() + "€ \n");
        }
    }

    void resumFacturacio(SessionFactory factory) {

        Session session = factory.openSession();
        try {
            session.beginTransaction();
            List<Double> precios = session.createQuery("select sum(preu_total) from Comanda where dni_client = :dni").setParameter("dni", this.getDni()).getResultList();

            for (Double precio : precios ){
                if (precio != null){
                    System.out.println( this.getNom() + " " + precio + "€");
                }
            }




        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        } finally {
            session.close();
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
}
