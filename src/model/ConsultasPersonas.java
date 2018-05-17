package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

        String sql = "UPDATE personas SET Nombres_Raz=?,Apellidos=?,Numero_Doc=?,Correo=?,Direccion=?,Telefono=?,Ubicacion=?,"
                + "Rep_Legal=?,Estado=?,Tipo_Persona=?,Tipo_Doc=? WHERE Numero_Doc=?";
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
                per.setNombres_Raz(rs.getString("Nombres_Raz"));
                per.setApellidos(rs.getString("Apellidos"));
                per.setNumero_Doc(Integer.parseInt(rs.getString("Numero_Doc")));
                per.setCorreo(rs.getString("Correo"));
                per.setDireccion(rs.getString("Direccion"));
                per.setTelefono(Integer.parseInt(rs.getString("Telefono")));
                per.setUbicacion(rs.getString("Ubicacion"));
                per.setRep_Legal(rs.getString("Rep_Legal"));
                per.setEstado(Integer.parseInt(rs.getString("Estado")));
                per.setEstado(Integer.parseInt(rs.getString("Tipo_Persona")));
                per.setEstado(Integer.parseInt(rs.getString("Tipo_Doc")));
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
}
