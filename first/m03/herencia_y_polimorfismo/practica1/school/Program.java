public class Program {
    
    public static void main(String[] args){
        
        Person persona = new Person("Ronald", "Dirección 22");
        Teacher profe = new Teacher("Sue", "Calle 11");
        Student estudiante = new Student("Jhon", "Calle 22", "IT", 1);
        InternationalStudent gringo = new InternationalStudent("Jim", "Street 22", "CC", 1, "EEUU");

        System.out.println("-----------------------");
        System.out.println("Nombre de Persona: " + persona.getName());
        System.out.println("Nombre de Teacher: " + profe.getName());
        System.out.println("Nombre de Student: " + estudiante.getName());
        System.out.println("Nombre de InternationalStudent: " + gringo.getName());
    }
}