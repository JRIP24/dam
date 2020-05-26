public class InternationalStudent extends Student{
    
    private String country;

    public InternationalStudent(String n, String a, String cy, int co, String coutr){
        super(n, a, cy, co);
        this.country = coutr;
        System.out.println("Soy el constructor de la clase InternationalStudent");
    }

    public String getCountry(){
        return this.country;
    }

    public void setCountry(String c){
        this.country = c;
    }


}