package shop;

import java.util.ArrayList;

public class Shop {
    
    private ArrayList<Product> stock;

    public Shop(){
        this.stock = new ArrayList<Product>();
    }

    public boolean addProduct(Product p){
        return this.stock.add(p);
    }

    public boolean removeProduct(Product p){
        return this.stock.remove(p);
    }

    public void listStock(){

        int totalHD = 0;
        int totalCPU = 0;

        System.out.println("CODI" + "\t" + "DESCRIPCIÓ" + "\t\t" + "UNI" + "\t" + "CAP/VEL" + "\t" + "PREU UNITAT" + "\t" + "PREU");
        System.out.println("----" + "\t" + "-----------" + "\t\t" + "---" + "\t" + "-------" + "\t" + "---------" + "\t" + "---");

        for (Product product : this.stock) {

            System.out.println(product.toString());
            
            if (product instanceof Cpu){
                
                totalCPU = totalCPU + product.getUnits();

            } else if (product instanceof HardDisk ){
                
                totalHD = totalHD + product.getUnits();
            }

        }

        System.out.println("\nNúmero total de discos duros en stock: " + totalHD);
        System.out.println("Número total de CPUs en stock: " + totalCPU);
        System.out.println("\nValor total del stock: " + this.stockValue());

    }

    public float stockValue(){

        float suma = 0;

        for (Product product : this.stock) {
            
            float precio = product.price() * product.getUnits();
            suma = suma + precio;
        }

        return suma;
    }



}