import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyBBDD {
	
	private String url;
	private String usuario;
	private String password;
	Connection con;
	
	
	public MyBBDD() throws SQLException {
		this.url = "jdbc:mysql://localhost/lamevabbdd";
		this.usuario = "lamevaapp";
		this.password = "contrasenya";
		
		this.con = DriverManager.getConnection(this.url, this.usuario, this.password);
		this.con.setAutoCommit(false);
		
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
