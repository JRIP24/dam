public class Program {
    
    public static void main(String[] args) {
        
        System.out.println("\n Cliente normal: \n");
        NormailClientBill normal = new NormailClientBill(10.0, 20.0, 30.0);
        System.out.println("DETALLE DE FACTURA");
        System.out.println("==================");
        System.out.println("Consumo: " + ((normal.totalAmount() - normal.sewerageAmount()) - normal.cleaningUpAmount()));
        System.out.println("Saneamiento: " + normal.cleaningUpAmount());
        System.out.println("Residuales: " + normal.sewerageAmount());
        System.out.println("Descuento aplicado a saneamiento: " + normal.cleaningUpDiscount);
        System.out.println("Descuento aplicado a residuales: " + normal.sewerageDiscount);
        System.out.println("TOTAL: " + normal.totalAmount());


        System.out.println("\n Família numerosa de tipo 1: \n");
        LargeFamily1Bill familia1 = new LargeFamily1Bill(10.0, 20.0, 30.0);
        System.out.println("DETALLE DE FACTURA");
        System.out.println("==================");
        System.out.println("Consumo: " + ((familia1.totalAmount() - familia1.sewerageAmount()) - familia1.cleaningUpAmount()));
        System.out.println("Saneamiento: " + familia1.cleaningUpAmount());
        System.out.println("Residuales: " + familia1.sewerageAmount());
        System.out.println("Descuento aplicado a saneamiento: " + familia1.cleaningUpDiscount);
        System.out.println("Descuento aplicado a residuales: " + familia1.sewerageDiscount);
        System.out.println("TOTAL: " + familia1.totalAmount());


        System.out.println("\n Família numerosa de tipo 2: \n");
        LargeFamily2Bill familia2 = new LargeFamily2Bill(10.0, 20.0, 30.0);
        System.out.println("DETALLE DE FACTURA");
        System.out.println("==================");
        System.out.println("Consumo: " + ((familia2.totalAmount() - familia2.sewerageAmount()) - familia2.cleaningUpAmount()));
        System.out.println("Saneamiento: " + familia2.cleaningUpAmount());
        System.out.println("Descuento aplicado a saneamiento: " + familia2.cleaningUpDiscount);
        System.out.println("Descuento aplicado a residuales: " + familia2.sewerageDiscount);
        System.out.println("Residuales: " + familia2.sewerageAmount());
        System.out.println("TOTAL: " + familia2.totalAmount());
        familia2.details();



    }
}