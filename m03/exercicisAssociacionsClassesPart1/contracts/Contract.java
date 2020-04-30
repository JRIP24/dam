
public class Contract {

    private int code;
    private String initialDate;
    private String endDate;
    private Company company;

    public Contract(){

    }

    public Contract(int c){
        this.code = c;
    }

    public Contract(int c, String idate, String edate){
        this.code = c;
        this.initialDate = idate;
        this.endDate = edate;
    }

    public int duration(){

    }

    //equals y hashcode
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
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
		Contract other = (Contract) obj;
		if (code != other.code)
			return false;
		return true;
	}


    public Company getCompany(){
        return this.company;
    }

    public String getEndDate(){
        return this.endDate;
    }

    public String getInitialDate(){
        return this.initialDate;
    }

    public void setCompany(Company comp){
        this.company = comp;
    }
    

}