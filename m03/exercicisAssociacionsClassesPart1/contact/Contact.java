import java.util.HashSet;

public class Contact{


    private int dni;//Se acepta solo el número de DNI, no letras
    private String nombre;
    private String telefono;
    private HashSet<Contact> contactos;

    //Constructores
    public Contact(){

    }

    public Contact(int d){
        this.dni = d;
    }

    public Contact(int d, String n, String phone){
        
        this.dni = d;
        this.nombre = n;
        this.telefono= phone;
        this.contactos = new HashSet<Contact>();
    }



    //Métodos

    public Contact search(int d){

        Contact cont = new Contact(0000000, "No encontrado", "---------");

        for (Contact c : this.contactos){

            if(c.getDni() == d){
                cont = c;
            }

        }

        return cont;
        
    }

    public boolean add(Contact c){

        if(this.equals(c)){
            return false;
        } else {
            return this.contactos.add(c);
        }
    }

    public boolean remove(Contact c){
        return this.contactos.remove(c);
    }

    public void removeAll(){
		this.contactos.clear();
    }
    
    public void listContacts(){

        for (Contact c : this.contactos){

            System.out.println("DNI: " + c.getDni() + ", Nombre: " + c.getName() + ", Teléfono: " + c.getPhone());

        }
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
		Contact other = (Contact) obj;
		if (dni != other.dni)
			return false;
		return true;
    }
    

    //Getters

    public int getDni(){
        return this.dni;
    }

    public String getName(){
        return this.nombre;
    }

    public String getPhone(){
        return this.telefono;
    }



}