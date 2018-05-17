
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Estado;


/**
 *
 * @author Maleja Gosman
 */
public class ConEstado extends Conexion{
    
    public ArrayList<Estado> llenar_combo() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conexion = getConexion();

        ArrayList<Estado> lista_Est = new ArrayList<Estado>();
        try {
            String q = "select * from estado;";
            ps = conexion.prepareStatement(q);
            rs = ps.executeQuery(q);
            System.out.println("Correcto");
        } catch (SQLException ex) {
            Logger.getLogger(ConTipoPer.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            while (rs.next()) {
                lista_Est.add(new Estado(rs.getInt("Id_Estado"), rs.getString("Nom_Estado")));
            }
            conexion.close();
        } catch (Exception e) {
        }
        return lista_Est;

    }
    
    
}
