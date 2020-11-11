import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
	
	
	static Politic createPolitic() {
		
		Scanner teclado = new Scanner(System.in);
		
		boolean salir = false;
		
		System.out.print("Introduzca el NIF: ");
		String nif = teclado.next();
		
		System.out.print("Introduzca el nombre: ");
		String nombre = teclado.next();
		
		System.out.print("Introduzca la fecha de nacimiento: ");
		String date = teclado.next();

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		Date data=null;
		try {
		    //Parsing the String
		    data = dateFormat.parse(date);
		    
		} catch (ParseException e) {
		    // TODO Auto-generated catch block
		    System.out.println("Error: " + e);
		}
		System.out.println(data);
		
		Politic politic = new Politic("ferf", "nom", data, 8000, true);
		
		return  politic;
		
		
	}
	
	
	

	public static void main(String[] args) throws SQLException{
		
		//Conexión a la BBDD
		String url="jdbc:mysql://localhost/lamevabbdd";
		
		String usuari="lamevaapp";
		String password="contrasenya";
		Connection con = DriverManager.getConnection(url, usuari, password);
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
		
		
		Politic pol = createPolitic();
		
		
		
		
		
		
		con.close();//Cerramos la conexión a la BBDD

	}

}
