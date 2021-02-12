public class Persona {

    private String nif;
    private String name;
    private int age;


    public Persona() {
    }

    public Persona(String nif, String name, int age) {
        this.nif = nif;
        this.name = name;
        this.age = age;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
