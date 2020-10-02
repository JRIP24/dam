import java.util.Scanner;

public class Program {


    static float price(float pre_ini, float desc){
        
        float pre_fin;
        float iva;
        //Aplicamos IVA
        iva = (pre_ini * 21) / 100;
        pre_ini = pre_ini + iva;

        //Aplicamos descuento
        desc = (pre_ini * desc) / 100;
        pre_fin = pre_ini - desc;

        return pre_fin;
    }

    public static void main(String[] args) {

        //Definimos variables
        Scanner teclado = new Scanner(System.in);        
        float precio_inicial;
        float precio_final;
        float descuento;


        System.out.println("Introduzca el precio inicial del producto:");
        precio_inicial = teclado.nextFloat();

        System.out.println("Introduzca el el % de descuento:");
        descuento = teclado.nextFloat();

        precio_final = price(precio_inicial, descuento);


        System.out.printf("El precio del producto es: %.2f€\n",precio_final);
    }

}