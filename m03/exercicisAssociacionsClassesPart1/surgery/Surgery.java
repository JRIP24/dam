import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;


public class Surgery{

    private String doctorName;

    private String speciality;

    private HashSet<Visit> visits;

    public Surgery(){

    }


    public Surgery(String name, String esp){

        this.doctorName = name.trim();
        this.speciality = esp.trim();

        this.visits = new HashSet<Visit>();
	}

	//Conversor de String a Date 

	public static Date stringToDate(String string){

        Date result = new Date();

        try{

            DateFormat newFormato = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
            result = newFormato.parse(string);
        } catch (java.text.ParseException e){
            e.printStackTrace();
        }

        return result;
	}
	
	//Conversor de Date a String
    public static String dateToString(Date date){

        String pattern = "dd/MM/yyyy-HH:mm:ss";

        DateFormat df = new SimpleDateFormat(pattern);

        String result = df.format(date);

        return result;
	}


	//Comprobamos si se solapan visitas
	public static boolean solapan(Date d, Date dInicio, Date dFinal){

		return d.after(dInicio) && d.before(dFinal);
	}



	
	//Métodos propios de la clase

	public boolean isProgrammable(Visit v){

		int coincidencias = 0;

		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();

		//Obtenemos la fecha en string
		String mydate = v.getVisitDateTime();
		
		//Pasamos la fecha de String a Date
		Date fecha = stringToDate(mydate);
		
		cal1.setTime(fecha);
		cal2.setTime(fecha);

		cal2.add(Calendar.MINUTE, 30);//Sumamos 30 min
		Date fechaMediaH = cal2.getTime();//Devuelve Date, la fecha de visita 30 min después


		for (Visit visitasProgramadas : this.visits){//Bucle for each

			String strDate = visitasProgramadas.getVisitDateTime();
			
			Date date = stringToDate(strDate);//Hora de inicio de la visita programada
			
			Calendar cal3 = Calendar.getInstance();
			cal3.setTime(date);
			cal3.add(Calendar.MINUTE, 30);
			Date dateMediaH = cal3.getTime(); //Hora del final de la visita programada

			boolean solapaInicio = solapan(fecha, date, dateMediaH);
			boolean solapaFinal = solapan(fechaMediaH, date, dateMediaH);
			boolean iguales = fecha.equals(date);

			if (solapaInicio || solapaFinal || iguales){
				coincidencias++;
			}
			
		}

		if (coincidencias > 0){
			return false;
		} else{
			return true;
		}
	}



	//Programar una visita
	public boolean program(Visit v) {

		if (isProgrammable(v)){
			return this.visits.add(v);
		} else {
			return false;
		}
	}

	//Cancelar visita
	public boolean cancel(Visit v) {
        return this.visits.remove(v);
	}

	public void cancelAll(){
		this.visits.clear();
	}
	
	public int countVisits() {
        return this.visits.size();
	}
	
	public int countVisits(String date1, String date2) {
		
		int contador = 0;

		Date f1 = stringToDate(date1);
		Date f2 = stringToDate(date2);

		for (Visit visitasProgramadas : this.visits){//Bucle for each

			String strDate = visitasProgramadas.getVisitDateTime();
			
			Date d = stringToDate(strDate);//Hora de inicio de la visita programada
			if (solapan(d, f1, f2)){
				contador++;
			}

		}

		return contador;
    }



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((doctorName == null) ? 0 : doctorName.hashCode());
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
		Surgery other = (Surgery) obj;
		if (doctorName == null) {
			if (other.doctorName != null)
				return false;
		} else if (!doctorName.equals(other.doctorName))
			return false;
		return true;
	}


	public String getDoctorName() {
		return this.doctorName;
	}
	
	
    
    
    
    
    
}