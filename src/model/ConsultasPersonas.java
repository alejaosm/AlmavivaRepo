package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Maleja Gosman
 */
public class ConsultasPersonas extends Conexion {

    public boolean registrar(Personas per) {

        PreparedStatement ps = null;
        Connection conexion = getConexion();

        String sql = "INSERT INTO personas(Nombres_Raz,Apellidos,Numero_Doc,Correo,Direccion,Telefono,Ubicacion"
                + ",Rep_Legal,Estado,Tipo_Persona,Tipo_Doc)VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, per.getNombres_Raz());
            ps.setString(2, per.getApellidos());
            ps.setInt(3, per.getNumero_Doc());
            ps.setString(4, per.getCorreo());
            ps.setString(5, per.getDireccion());
            ps.setInt(6, per.getTelefono());
            ps.setString(7, per.getUbicacion());
            ps.setString(8, per.getRep_Legal());
            ps.setInt(9, per.getEstado());
            ps.setInt(10, per.getTipo_Persona());
            ps.setInt(11, per.getTipo_Doc());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }
    }

    public boolean modificar(Personas per) {

        PreparedStatement ps = null;
        Connection conexion = getConexion();

        String sql = "UPDATE personas SET Nombres_Raz=?, Apellidos=?,Numero_Doc=?,Correo=?,Direccion=?,Telefono=?,Ubicacion=?,"
                + "Rep_Legal=?,Estado=?,Tipo_Persona=?,Tipo_Doc=? WHERE Id_Persona=?";
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, per.getNombres_Raz());
            ps.setString(2, per.getApellidos());
            ps.setInt(3, per.getNumero_Doc());
            ps.setString(4, per.getCorreo());
            ps.setString(5, per.getDireccion());
            ps.setInt(6, per.getTelefono());
            ps.setString(7, per.getUbicacion());
            ps.setString(8, per.getRep_Legal());
            ps.setInt(9, per.getEstado());
            ps.setInt(10, per.getTipo_Persona());
            ps.setInt(11, per.getTipo_Doc());
            ps.setInt(12, per.getId_Persona());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }
    }

    public boolean eliminar(Personas per) {

        PreparedStatement ps = null;
        Connection conexion = getConexion();

        String sql = "DELETE FROM personas WHERE Numero_Doc=?";
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, per.getNumero_Doc());

            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }
    }

    public boolean buscar(Personas per) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conexion = getConexion();

        String sql = "SELECT * FROM personas WHERE Numero_Doc=?";
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, per.getNumero_Doc());

            rs = ps.executeQuery();

            if (rs.next()) {  // si obtiene valores se agregan al modelo
                
                per.setId_Persona(rs.getInt("Id_Persona"));
                per.setNombres_Raz(rs.getString("Nombres_Raz"));
                per.setApellidos(rs.getString("Apellidos"));
                per.setNumero_Doc(rs.getInt("Numero_Doc"));
                per.setCorreo(rs.getString("Correo"));
                per.setDireccion(rs.getString("Direccion"));
                per.setTelefono(rs.getInt("Telefono"));
                per.setUbicacion(rs.getString("Ubicacion"));
                per.setRep_Legal(rs.getString("Rep_Legal"));
                per.setEstado(rs.getInt("Estado"));
                per.setTipo_Persona(rs.getInt("Tipo_Persona"));
                per.setTipo_Doc(rs.getInt("Tipo_Doc"));
                return true;
            }
            return false;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }
    }
    
    public static ArrayList<String> llenar_combo(TipoPer tip) {

        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<String> lista = new ArrayList<String>();
        String q = "SELECT * FROM personas";
        try {
            rs = ps.executeQuery(q);
            System.out.println("Correcto");

        } catch (Exception e) {
            System.out.println("No Correcto");
        }
        try {
            while (rs.next()) {
                lista.add(tip.getNom_Tipo_Persona());
            }
        } catch (Exception e) {
        }
        return lista;
    }
}
