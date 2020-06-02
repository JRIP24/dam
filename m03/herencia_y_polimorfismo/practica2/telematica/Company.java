import java.util.HashSet;

public class Company {
    
    private HashSet<User> users;

    public Company(){
        this.users = new HashSet<User>();
    }

    public boolean add(User u){
        return this.users.add(u);
    }

    public void listUsers(){
        
    }

}