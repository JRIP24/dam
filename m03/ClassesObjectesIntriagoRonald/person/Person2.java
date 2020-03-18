package person;

public class Person2{


    public static void main(String[] args){
        

        //Constructor por defecto
        Person1 p = new Person1();
        System.out.println(p.getName());

        Person1 p2 = new Person1("Ronald");
        System.out.println(p2.getName());

        Person1 p3 = new Person1("Jose", 18, 1.72, 'h', false);

        System.out.println(p3.getName());
        
    }
    
}