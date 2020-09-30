public class Person{

    private String name;
    private String address;

    public Person(String n, String a){

        this.name = n;
        this.address = a;
        System.out.println("Soy el constructor de la clase Persona");
    }

    public String getName(){
        return this.name;
    }

    public void setName(String n){
        this.name = n;
    }

    public String getAddress(){
        return this.address;
    }

    public void setAddress(String a){
        this.address = a;
    }

}