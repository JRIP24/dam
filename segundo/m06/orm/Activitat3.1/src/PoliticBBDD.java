import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jordi
 */
public class PoliticBBDD implements Closeable {
    
    Connection con;
    
    public PoliticBBDD() throws SQLException {
        String url="jdbc:mysql://localhost/db_prova"; // db_prova, 3306
        String usuari="db_user";
        String password="contrasenya";
        this.con = DriverManager.getConnection(url, usuari, password);       
        System.out.println("Connexió oberta correctament.");
    }
    
    @Override
    public void close() {
        try {
            con.close();
            System.out.println("Connexió tancada correctament.");
        } catch (SQLException ex) {
            System.err.println("Error al tancar la connexió.");
        }
    }
    
    public void creaTaula () throws SQLException {
        String sentenciaSQL = "DROP TABLE politic";
        Statement statement = con.createStatement();
        statement.execute(sentenciaSQL);
        sentenciaSQL = "CREATE TABLE politic ("
                + "nif VARCHAR(10) PRIMARY KEY,"
                + "nom VARCHAR(100) NOT NULL,"
                + "dataNaixement DATE,"
                + "sou INT,"
                + "esCorrupte ENUM('S','N')"
                + ")";
        statement = con.createStatement();
        statement.execute(sentenciaSQL);
        System.out.println("Taula creada correctament.");
    }
    
    public void insereix (Politic p) throws SQLException {
        String sentenciaSQL = "insert into politic (nif,nom,dataNaixement,sou,esCorrupte) values (?,?,?,?,?)";
        PreparedStatement sentenciaPreparada = con.prepareStatement(sentenciaSQL);
        sentenciaPreparada.setString(1,p.nif);
        sentenciaPreparada.setString(2,p.nom);
        sentenciaPreparada.setDate(3,java.sql.Date.valueOf(p.dataNaixement));
        sentenciaPreparada.setInt(4,p.sou);
        sentenciaPreparada.setString(5, ((p.esCorrupte) ? "S" : "N"));
        sentenciaPreparada.executeUpdate();    
        System.out.println("Polític inserit correctament.");
    }
    
    public List<Politic> selecciona() throws SQLException {
        ArrayList<Politic> llista = new ArrayList<>();
        
        String sentenciaSQL = "select nif,nom,dataNaixement,sou,esCorrupte from politic";
        Statement statement = con.createStatement();
        statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sentenciaSQL);
        
        while (rs.next()) {
            Politic p = new Politic(false);
            p.nif = rs.getString("nif");
            p.nom = rs.getString("nom");
            p.dataNaixement =  rs.getDate("dataNaixement").toLocalDate();
            p.esCorrupte = rs.getString("esCorrupte").equals("S");
            p.sou = rs.getInt("sou");
            llista.add(p);
        }
        
        return llista;
    }
}