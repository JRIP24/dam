import java.awt.dnd.DropTargetDragEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Program {
	
	
	static boolean integerToBoolean(int entero) {//Antes de llamar a esta función hay que asegurarse de que int es 0 o 1
		
		boolean booleano = false;
		
		if (entero == 1) {
			booleano = true;
		}
		
		return booleano;
		
	}
	
	static int booleanToInteger(boolean booleano) {
		
		return  booleano ? 1 : 0;
	}
	
	static Date stringToDate(String strDate) {
		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = null;
		
		try {
		    //Parsing the String
		    fecha = formatter.parse(strDate);
		    
		} catch (ParseException e) {
		    // TODO Auto-generated catch block
		    System.out.println("Error: " + e);
		}
		
		
		return fecha;
		
	}
	
	
	static Politic createPolitic(){
		
		Scanner teclado = new Scanner(System.in);
		
		boolean salir = false;
		String nif = "";
		String nombre = "";
		Date fecha = null;
		int sueldo = 0;
		boolean esCorrupto = false;
		
		while (!salir) {
			
			System.out.print("Introduzca el NIF: ");
			nif = teclado.next();
			
			System.out.print("Introduzca el nombre: ");
			nombre = teclado.next();

			
			System.out.print("Introduzca la fecha de nacimiento (yyyy-MM-dd): ");
			String date = teclado.next();
			fecha = stringToDate(date);
			
			if (fecha != null){
			    
			    System.out.print("Introduzca el sueldo: ");
			    if (teclado.hasNextInt()) {
			    	
			    	sueldo = teclado.nextInt();
			    	
			    	System.out.print("Es corrupto? (1 para si y 0 para no): ");
			    	
			    	if (teclado.hasNextInt() ) {
						
			    		int opcion = teclado.nextInt();
			    		
			    		if (opcion == 0 || opcion == 1) {
			    			
							if (opcion == 1) {
								esCorrupto = true;
							}
							
							salir = true;
						
			    		} else {
							System.out.println("Error: No se ha introducido 0 o 1");
						}
			    					    		
					} else {
						System.out.println("Error, no se ha introducido un número");
					}
			    	
			    	
			    } else {
			    	
			    	System.out.println("Error, no se ha introducido un número");
			    }
			    
			    
			    
			    
			} else {

			    System.out.println("Error: fecha incorrecta");
			}
			
		}
				
		
		Politic politic = new Politic(nif, nombre, fecha, sueldo, esCorrupto);
		
		return  politic;
		
		
	}
	
	static void insertarPolitico(Politic politico, Connection con) throws SQLException {
		
		//DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date sqlDate = new java.sql.Date(politico.getDataNaixement().getTime()); //Fecha paera formato SQL
		int corrupto = booleanToInteger(politico.isEsCorrupte()); //Booleano para formato SQL
		
		String sentenciaSQL = "INSERT INTO politic (nif, nom, dataNaixement, sou, esCorrupte ) VALUES (?,?,?,?,?)";
		PreparedStatement sentenciaPreparada = con.prepareStatement(sentenciaSQL);
		sentenciaPreparada.setString(1,politico.getNif());
		sentenciaPreparada.setString(2,politico.getNom());
		sentenciaPreparada.setString(3,sqlDate + "");
		sentenciaPreparada.setString(4,politico.getSou() + "");
		sentenciaPreparada.setString(5,corrupto + "");
		int insercion = sentenciaPreparada.executeUpdate();
		
		if (insercion == 1) {
			
			System.out.println("Datos guardados correctamente");
			
		} else {
			
			System.out.println("Ha ocurrido un error al insertar los datos");
			
		}
		
	}
	
	static ArrayList<Politic> leerPoliticos(ArrayList<Politic> politicos, Connection con) throws SQLException {
		
		Statement statement = con.createStatement();
		
		String sentenciaSQL = "SELECT * FROM politic";
		ResultSet rs = statement.executeQuery(sentenciaSQL);
		
		int contador = 0;
		
		while (rs.next()) {
			
			String nif = rs.getString("nif");
			String nombre = rs.getString("nom");
			Date fecha = stringToDate(rs.getString("dataNaixement"));
			int sueldo = rs.getInt("sou");
			boolean esCorrupo = rs.getBoolean("esCorrupte");
			
			politicos.add(new Politic(nif, nombre, fecha, sueldo, esCorrupo));
			
			contador++;
		}
		
		if(contador > 0) {
			
			System.out.println("Se han añadido " + contador + " políticos");
			
		} else {
			
			System.out.println("No se han añadido políticos");
		}
		
		return politicos;
		
	}
	

	public static void main(String[] args) throws SQLException{
		
		//Conexión a la BBDD
		String url="jdbc:mysql://localhost/lamevabbdd";
		
		ArrayList<Politic> politicos = new ArrayList<Politic>();
		
		String usuari="lamevaapp";
		String password="contrasenya";
		Connection con = DriverManager.getConnection(url, usuari, password);
		String sentenciaSQL; //Se usará más adelante para las sentencias SQL
		
		
		/* INSERT
		sentenciaSQL = "insert into assignatura (nom) values ('Acces a Dades')";
		statement = con.createStatement();
		statement.executeUpdate(sentenciaSQL);
		
		INSERT CONCAT
		sentenciaSQL = "insert into assignatura (nom) values (?)";
		PreparedStatement sentenciaPreparada = con.prepareStatement(sentenciaSQL);
		sentenciaPreparada.setString(1,"Acces a dades");
		sentenciaPreparada.executeUpdate();
		
		SELECT
		sentenciaSQL = "select * from assignatura";
		ResultSet rs = statement.executeQuery(sentenciaSQL);
		while (rs.next()) System.out.println("NOM: " + rs.getString("NOM"));*/
		
		
		//Exercici 1
		/*
		String sentenciaSQL = "CREATE TABLE politic ("
		+ "nif VARCHAR(9), "
		+ "nom VARCHAR(50), "
		+ "dataNaixement DATE, "
		+ "sou INT, "
		+ "esCorrupte BOOLEAN)";
		Statement statement = con.createStatement();
		statement.execute(sentenciaSQL);*/
		
		//Exercici 3
		
		/*
		Politic pol = createPolitic();
		System.out.println(pol.toString());
		
		insertarPolitico(pol, con);*/
		
		
		
		//Exercici 4
		leerPoliticos(politicos, con);
		for (Politic politic : politicos) {
			
			System.out.println(politic.toString());
			
		}
		
		
		
		
		
		con.close();//Cerramos la conexión a la BBDD

	}

}
