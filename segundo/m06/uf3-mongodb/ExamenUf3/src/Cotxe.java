/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package edt.dam.m6.uf3.exuf3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jordi
 */
public class Cotxe {
    String matricula;
    int cavalls;
    NomComercial nom_comercial;
    List<Revisio> revisions;
    
    public Cotxe(String matricula, int cavalls, NomComercial nom_comercial) {        
        this.matricula = matricula;
        this.cavalls = cavalls;
        this.nom_comercial = nom_comercial;
        this.revisions = new ArrayList<>(); 
    }
        
    @Override
    public String toString () {
        String valor = "matricula: "+this.matricula+", cavalls: "+this.cavalls+
        ", nom comercial: "+this.nom_comercial+"\n";
        valor += "--Llista de revisions:--\n";        
        for (Revisio r : revisions) {
           valor += "*"+r+"\n";
        }        
        return valor;
    }
}
