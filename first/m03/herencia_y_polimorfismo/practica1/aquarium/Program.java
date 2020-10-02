public class Program {
    
    public static void main(String[] args) {
        
        System.out.println("PEZ \n");
        Fish pez = new Fish("Pez Payaso", "Pomacentridae", 'M', 40.0, 20.0, 7.2, 5.8);
        pez.setOrigin("Arrecifes de coral del Indo-Pacífico");
        pez.setDiet('O');
        pez.setLength(18.0);
        System.out.println("Nombre: " + pez.getName());
        System.out.println("Familia: " + pez.getFamily());
        System.out.println("Tipo de luz que necesita: " + pez.lightType());
        System.out.println("Margen de temperatura: " + pez.temperature());
        System.out.println("Margen de PH: " + pez.acidity());
        System.out.println("Origen: " + pez.getOrigin());
        System.out.println("Tipo de dieta: " + pez.dietType());
        System.out.println("Longitud: " + pez.getLength());
        System.out.println("-------------------------- \n");


        System.out.println("PLANTA \n");
        Plant planta = new Plant("Feofíceas", "Heterokontophyta", 'M', 15, 7, 7.2, 4.1);
        planta.setType('B');
        System.out.println("Nombre: " + planta.getName());
        System.out.println("Familia: " + planta.getFamily());
        System.out.println("Tipo de luz que necesita: " + planta.lightType());
        System.out.println("Margen de temperatura: " + planta.temperature());
        System.out.println("Margen de PH: " + planta.acidity());
        System.out.println("Tipo: " + planta.plantType());
        System.out.println("-------------------------- \n");






    }
}