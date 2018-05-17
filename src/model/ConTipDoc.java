
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TipoDoc;



/**
 *
 * @author Maleja Gosman
 */
public class ConTipDoc extends Conexion {
    
    
    public ArrayList<TipoDoc> llenar_combo() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conexion = getConexion();

        ArrayList<TipoDoc> lista_Doc = new ArrayList<TipoDoc>();
        try {
            String q = "select * from tipo_doc;";
            ps = conexion.prepareStatement(q);
            rs = ps.executeQuery(q);
            System.out.println("Correcto");
        } catch (SQLException ex) {
            Logger.getLogger(ConTipoPer.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            while (rs.next()) {
                lista_Doc.add(new TipoDoc(rs.getInt("Id_Tipo_Doc"), rs.getString("Nom_Tipo_Doc")));
            }
            conexion.close();
        } catch (Exception e) {
        }
        return lista_Doc;

    }
}
