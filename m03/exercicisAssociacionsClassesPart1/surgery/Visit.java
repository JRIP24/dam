public class Visit {

    private String visitDateTime;
	private String patientName;


    //Constructores
    
    public Visit(){

    }

    public Visit(String dateTime){
        this.visitDateTime = dateTime.trim();
    }

    public Visit(String dateTime, String name){
        this.visitDateTime = dateTime.trim();
        this.patientName = name.trim();
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((visitDateTime == null) ? 0 : visitDateTime.hashCode());
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
		Visit other = (Visit) obj;
		if (visitDateTime == null) {
			if (other.visitDateTime != null)
				return false;
		} else if (!visitDateTime.equals(other.visitDateTime))
			return false;
		return true;
	}

	public String getVisitDateTime() {
		return this.visitDateTime;
	}


	public String getPatientName() {
		return this.patientName;
	}
	
	




}