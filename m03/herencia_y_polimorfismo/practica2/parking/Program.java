public class Program {
    
    public static void main(String[] args) {
        
        Parking park = new Parking(15);
        
        Car coche =new Car("321BOM", 75, 4);
        Car coche2 =new Car("300BOM", 75, 6);
        Car coche3 =new Car("350IO", 90, 2);
        
        Motorbike moto = new Motorbike("SUZUI8", 40);
        Motorbike moto2 = new Motorbike("GP22", 70);
        Motorbike moto3 = new Motorbike("G422", 75);
        
        park.add(coche, 2);
        park.add(coche2, 12);
        park.add(coche3, 12);//No se añadirá, ya que la plaza 12 ya está ocupada
        park.add(moto, 13);
        park.add(moto2, 16);//No se añadirá, ya que el parking es de 15 plazas
        park.add(moto3, 4);
        park.remove(13);//Eliminamos la moto de la plaza 13

        park.reportTotal("reporte.txt");
        System.out.println("Cuota del coche en la plaza 2: " + park.calculateFee(2) + "€");
        System.out.println("Cuota total recaudada en el parking: " + park.calculateTotal() +"€");
    }
}