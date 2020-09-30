import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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


    //Conversor de String a Date 

	public static Date stringToDate(String string){

        Date result = new Date();

        try{

            DateFormat newFormato = new SimpleDateFormat("dd/MM/yyyy");
            result = newFormato.parse(string);
        } catch (java.text.ParseException e){
            e.printStackTrace();
        }

        return result;
	}
	
	//Conversor de Date a String
    public static String dateToString(Date date){

        String pattern = "dd/MM/yyyy";

        DateFormat df = new SimpleDateFormat(pattern);

        String result = df.format(date);

        return result;
	}

    public int duration(){

        Date finicio = stringToDate(initialDate);
        Date ffinal = stringToDate(endDate);

        int resultado = (int) ((ffinal.getTime() - finicio.getTime()) / 86400000 ); //86400000 = 1000 * 60 * 60 * 24

        return resultado;


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