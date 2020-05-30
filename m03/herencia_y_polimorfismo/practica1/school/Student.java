public class Student extends Person {
    
    private String cycle;
    private int course;

    public Student(String n, String a, String cy, int co){
        super(n, a);
        this.cycle = cy;
        this.course = co;

        System.out.println("Soy el constructor de la clase Student");

    }

    public String getCycle(){
        return this.cycle;
    }

    public void setCycle(String c){
        this.cycle = c;
    }

    public int getCourse(){
        return this.course;
    }

    public void setCourse(int c){
        this.course = c;
    }


}