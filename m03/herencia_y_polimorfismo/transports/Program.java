public class Program {
    
    public static void main(String[] args) {
        
        Car coche = new Car("321BOOM", 80, "Gasolina", 1.17, 0.05);
        System.out.println(coche.cost(9.6));
        System.out.println("-------------------------");

        Bicycle bike = new Bicycle("BMX21", 8, 3);
        System.out.println("Bicicleta");
        System.out.println(bike.getId());
        System.out.println(bike.cost(9.6));
        System.out.println(bike.time(9.6));
    }
}