import java.util.HashSet;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person{

    private int dni;
    private String name;
    private HashSet<Contract> contracts;


    //Constructores

    public Person(){

        this.contracts = new HashSet<Contract>();
    }

    public Person(int d){

        this.dni = d;
        this.contracts = new HashSet<Contract>();
    }

    public Person(int d, String n){

        this.dni = d;
        this.name = n;
        this.contracts = new HashSet<Contract>();
    }


    //Métodos

    public int workedTime(){

        int suma = 0;

        for (Contract c : this.contracts){

            suma = suma + c.duration();
        }

        return suma;

    }

    public static boolean solapan(Date d, Date dInicio, Date dFinal){

		return d.after(dInicio) && d.before(dFinal);
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
    

    public int nCompanies(){

        int num = 0;

        HashSet<Integer> companyias = new HashSet<Integer>();

        for (Contract c : this.contracts){

            Company comp =  c.getCompany();

            companyias.add(comp.getCif());

        }

        num = companyias.size();

        return num;

    }

    public boolean signContract(Contract contract){


        boolean firmar= true;

        String fIni = contract.getInitialDate();
        String  fFin= contract.getEndDate();

        Date dIni = stringToDate(fIni);//Fecha de inicio del contrato a firmar
        Date dFin = stringToDate(fFin);//Fecha final del contrato a firmar

        Company comp1 = contract.getCompany();

        for (Contract c : this.contracts){

            Company comp2 = c.getCompany();

            String d1 = c.getInitialDate();
            String d2 = c.getEndDate();

            Date cIni = stringToDate(d1);
            Date cFin = stringToDate(d2);

            if (comp1.equals(comp2)){

                if (solapan(dIni, cIni, cFin) || solapan(dFin, cIni, cFin)){
                    firmar = false;
                } else {
                    firmar = true;
                }
            }
            

        }

        if (firmar){

            return this.contracts.add(contract);

        } else {

            return false;
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
		Person other = (Person) obj;
		if (dni != other.dni)
			return false;
		return true;
    }
    
    public String getName(){
        return this.name;
    }


}