import java.util.HashSet;

public class Person{

    private int dni;
    private String name;
    private HashSet<Contract> contracts;


    //Constructores

    public Person(){

    }

    public Person(int d){

        this.dni = d;
    }

    public Person(int d, String n){

        this.dni = d;
        this.name = n;
    }


    //Métodos

    public int workedTime(){

    }

    public int nCompanies(){

    }

    public boolean signContract(Contract contract){

    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dni;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (dni != other.dni)
			return false;
		return true;
	}


}