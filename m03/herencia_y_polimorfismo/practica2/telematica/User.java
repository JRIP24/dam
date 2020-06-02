import java.util.HashSet;

public abstract class User {
    
    private String dni;
    private String name;
    protected double priceMinute;
    protected HashSet<Connection> connections;

    public User(String n, String d, double pM){
        this.name = n;
        this.dni = d;
        this.priceMinute = pM;
        this.connections = new HashSet<Connection>();
    }

    public boolean add(Connection c){
        return this.connections.add(c);
    }

    public double totalMinutes(){

    }

    public abstract double billAmount();

    public void reset(){

    }

    public String getDni() {
		return this.dni;
	}


	public String getName() {
		return this.name;
	}


	public HashSet<Connection> getConnections() {
		return this.connections;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
		User other = (User) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

    



}