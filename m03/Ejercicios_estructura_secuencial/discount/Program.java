import java.util.Scanner;

public class Program {


    static float discount(float pr_pag, float pre_tar){
       
        float num_dif = pre_tar - pr_pag;
        float desc = (num_dif * 100)/pre_tar;

        return desc;
        
    }

    public static void main(String[] args) {

        //Definimos variables
        Scanner teclado = new Scanner(System.in);        
        float precio_tarifa;
        float precio_pagado;
        float descuento;

        System.out.println("Introduzca el precio de tarifa");
        precio_tarifa = teclado.nextFloat();

        System.out.println("Introduzca el precio pagado");
        precio_pagado = teclado.nextFloat();

        descuento = discount(precio_pagado, precio_tarifa);

        System.out.println("Se ha aplicado un " + descuento + "% de descuento" );

    }

}