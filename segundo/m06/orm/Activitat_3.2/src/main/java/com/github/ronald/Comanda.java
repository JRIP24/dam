package com.github.ronald;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

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

    public Comanda(int num_comanda, double preu_total, Date data, int dni) {
        this.num_comanda = num_comanda;
        this.preu_total = preu_total;
        this.data = data;
        this.dni_client = dni;
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

    @Override
    public String toString() {
        return "Comanda{" +
                "num_comanda=" + num_comanda +
                ", preu_total=" + preu_total +
                ", data=" + data +
                ", dni_client=" + dni_client +
                '}';
    }
}
