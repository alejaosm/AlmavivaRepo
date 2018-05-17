package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TipoPer;

/**
 *
 * @author Maleja Gosman
 */
public class ConTipoPer extends Conexion {

    public ArrayList<TipoPer> llenar_combo() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conexion = getConexion();

        ArrayList<TipoPer> lista = new ArrayList<TipoPer>();
        try {
            String q = "select * from tipo_persona;";
            ps = conexion.prepareStatement(q);
            rs = ps.executeQuery(q);
            System.out.println("Correcto");
        } catch (SQLException ex) {
            Logger.getLogger(ConTipoPer.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            while (rs.next()) {
                lista.add(new TipoPer(rs.getInt("Id_Tipo_Persona"), rs.getString("Nom_Tipo_Persona")));
            }
            conexion.close();
        } catch (Exception e) {
        }
        return lista;

    }

}
