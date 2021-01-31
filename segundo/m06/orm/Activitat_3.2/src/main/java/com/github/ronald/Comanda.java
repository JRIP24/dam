package com.github.ronald;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Entity
@Table(name = "comanda")
public class Comanda implements Serializable {

    @Id
    private int num_comanda;
    private double preu_total;
    private Date data;
    private int dni_client;

    public Comanda() {
    }

    public Comanda(int num_comanda, double preu_total, Date data, int dni_client) {
        this.num_comanda = num_comanda;
        this.preu_total = preu_total;
        this.data = data;
        this.dni_client = dni_client;
    }

    public Comanda (boolean demanaTeclat, Client client) {
        if (demanaTeclat){
            Scanner teclat = new Scanner(System.in);
            String fecha;
            System.out.print("Num. de comanda:");
            this.setNum_comanda(teclat.nextInt());

            System.out.print("Preu de comanda: ");
            this.setPreu_total(teclat.nextDouble());

            this.dni_client = client.getDni();

            boolean dataCorrecta = false;
            while (!dataCorrecta) {
                System.out.print("Introdueix la data de naixement (dia/mes/any): ");

                fecha = teclat.next();
                try{
                    this.data = java.sql.Date.valueOf(LocalDate.parse(fecha, DateTimeFormatter.ofPattern("d/MM/yyyy")));
                    dataCorrecta = true;
                } catch (Exception e){
                    System.out.println("Error: " + e.getMessage());
                }


            }

        }
    }

    void insertComanda(SessionFactory factory){

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







    public int getNum_comanda() {
        return num_comanda;
    }

    public void setNum_comanda(int num_comanda) {
        this.num_comanda = num_comanda;
    }

    public double getPreu_total() {
        return preu_total;
    }

    public void setPreu_total(double preu_total) {
        this.preu_total = preu_total;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getDni_client() {
        return dni_client;
    }

    public void setDni_client(int dni_client) {
        this.dni_client = dni_client;
    }
}
