/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package edt.dam.m6.uf3.exuf3;

public class NomComercial {
    String marca;
    String model;
    
    public NomComercial (String marca, String model) {
        this.marca = marca;
        this.model = model;
    }
    
    @Override
    public String toString () {
        String valor = "marca: "+this.marca+", model: "+this.model;
        return valor;
    }
            
}
