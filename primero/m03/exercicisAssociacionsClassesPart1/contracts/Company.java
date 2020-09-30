
public class Company {

    private int cif;
    private String name;
    private String sector;

    public Company(){

    }

    public Company(int c){
        this.cif = c;
    }

    public Company(int c, String n, String s){

        this.cif = c;
        this.name = n;
        this.sector = s;

    }

    //equals y hashcode
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cif;
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
		Company other = (Company) obj;
		if (cif != other.cif)
			return false;
		return true;
	}


    public int getCif(){
        return this.cif;
    }



}