public class Program {
    
    public static void main(String[] args) {
        
        Car coche = new Car("321BOOM", 80, "Gasolina", 1.17, 0.05);
        double cocheDist = 9.6;
        System.out.println("Coche");
        System.out.println("Id: " + coche.getId());
        System.out.println("Tipo de combustible: " + coche.getFuelType());
        System.out.println("Precio por litro: " + coche.getLiterPrice() +"€");
        System.out.println("Litros por Km: " + coche.getLitersKm());
        System.out.println("Velocidad: " + coche.getSpeed() + "km/h");
        System.out.println("Tempo en recorrer " + cocheDist + "km: " + coche.time(cocheDist) + "h");
        System.out.println("Costo: " + coche.cost(cocheDist) + "€");
        System.out.println("-------------------------");

        Bicycle bike = new Bicycle("BMX21", 8, 3);
        double bikeDist = 6.5;
        System.out.println("Bicicleta");
        System.out.println("Id: " + bike.getId());
        System.out.println("Número de marchas: " + bike.getNGears());
        System.out.println("Velocidad: " + bike.getSpeed() + "km/h");
        System.out.println("Tempo en recorrer " + bikeDist + "km: " + bike.time(bikeDist) + "h");
        System.out.println("Costo: " + bike.cost(bikeDist) + "€");
        System.out.println("-------------------------");


        Underground metro = new Underground("M19", 26.30, 10.00);
        double metroDist = 6.5;
        System.out.println("Metro");
        System.out.println("Id: " + metro.getId());
        System.out.println("Precio del ticket: " + metro.getTicketPrice());
        System.out.println("Velocidad: " + metro.getSpeed() + "km/h");
        System.out.println("Tempo en recorrer " + metroDist + "km: " + metro.time(metroDist) + "h");
        System.out.println("Costo: " + metro.cost(metroDist) + "€");
        System.out.println("-------------------------");
    }
}