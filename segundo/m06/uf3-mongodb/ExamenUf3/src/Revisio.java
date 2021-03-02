/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package edt.dam.m6.uf3.exuf3;

/**
 *
 * @author Jordi
 */
public class Revisio {
     int any;
     boolean favorable;
     String comentaris;
     
     public Revisio (int any, boolean favorable, String comentaris) {
         this.any = any;
         this.favorable = favorable;
         this.comentaris = comentaris;
     }
     
     @Override
     public String toString () {
         String valor = "any: "+this.any+", favorable?: "+(this.favorable?"Sí":"No")+", comentaris: "+this.comentaris;
         return valor;
     }
}
