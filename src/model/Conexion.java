package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maleja Gosman
 */
public class Conexion {

    private final String base = "AlmavivaPrueba";
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/" + base;
    private final String classforname = "com.mysql.jdbc.Driver";
    private String error;   
    private Connection conexion = null;

    public Connection getConexion() {
        try {

            Class.forName(classforname);
            conexion = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
        } catch (SQLException e) {
            
            System.err.println(e);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
}
