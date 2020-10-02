import java.util.HashSet;

public class Teacher extends Person{

    private HashSet<String> subjects;

    public Teacher(String n, String a){
        super(n, a);
        this.subjects = new HashSet<String>();

        System.out.println("Soy el constructor de la clase Teacher");

    }

    public boolean addSubject(String subj){
        return this.subjects.add(subj);
    }

    public boolean removeSubject(String subj){
        return this.subjects.remove(subj);
    }

}