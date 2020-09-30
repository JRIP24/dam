package person;

public class Person1{

    private String name;
    private int age;
    private double height;
    private char sex;
    private boolean married;

    public Person1(){
        this.name = "Jhon";
    }

    public Person1(String n){
        this.name = n;
    }

    public Person1(String n, int ag, double hg, char sx, boolean marr){
        
        this.name = n;
        this.age = ag;
        this.height = hg;
        this.sex = sx;
        this.married = marr;
    }

    //Getters

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public double getHeight(){
        return this.height;
    }

    public char getSex(){
        return this.sex;
    }

    public boolean getMarried(){
        return this.married;
    }

    //Setters
    
    public void setName(String n){
        this.name = n;
    }

    public void setAge(int ag){
        this.age = ag;
    }

    public void setHeight(double hg){
        this.height = hg;
    }

    public void setSex(char sx){
        this.sex = sx;
    }

    public void setMarried(boolean marr){
        this.married = marr;
    }
}