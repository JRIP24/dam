package people;

public class Person {
	
	public Person(String name, String dni, int age, char gender) {
		super();
		this.nombre = name;
		this.dni = dni;
		this.age = age;
		this.gender = gender;
	}
	private String nombre;
	private String dni;
	private int age;
	private char gender;
	public String getName() {
		return nombre;
	}
	public void setName(String name) {
		this.nombre = name;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + gender;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		if (age != other.age)
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (gender != other.gender)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Person [name=" + nombre + ", dni=" + dni + ", age=" + age + ", gender=" + gender + "]";
	}
	
	
	

}
