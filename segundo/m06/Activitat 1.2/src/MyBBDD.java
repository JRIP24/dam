import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyBBDD {
	
	private String url;
	private String usuario;
	private String password;
	private Connection con;
	
	
	public MyBBDD() throws SQLException {
		this.url = "jdbc:mysql://localhost/lamevabbdd";
		this.usuario = "lamevaapp";
		this.password = "contrasenya";
		
		this.con = DriverManager.getConnection(this.url, this.usuario, this.password);
		System.out.println("Se ha establecido la conexión con la BBDD correctamente");
		
	}
	
	public void close() {
        try {
            this.con.close();
            System.out.println("Se ha cerrado la conexión con la BBDD");
            
        } catch (SQLException ex) {
        	
            System.err.println("Error: No se ha podido cerrar la conexón con la BBDD");
        }
    }
	
	
	

	
	
	
	
	
	

}
