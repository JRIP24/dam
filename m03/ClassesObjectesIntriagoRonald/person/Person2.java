package person;

public class Person2{


    public static void main(String[] args){

        //Constructor por defecto
        Person1 p = new Person1();

        //Constructor con nombre
        Person1 p2 = new Person1("Jose");

        //Constructor con todos los datos
        Person1 p3 = new Person1("Ronald", 18, 1.72, 'h', false);
        System.out.println("Nombre: " + p3.getName());
        System.out.println("Edad: " + p3.getAge());
        System.out.println("Altura: " + p3.getHeight());
        System.out.println("Sexo: " + p3.getSex());
        System.out.println("Casado/a?: " + p3.getMarried());
        
    }
    
}