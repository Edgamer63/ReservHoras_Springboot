package jekmy.proyect.grupo1.DAO;

import jekmy.proyect.grupo1.ConnectionManager;
import jekmy.proyect.grupo1.DTO.FormReservaHoras;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FormReservaHorasDAO {
    private Connection conexion;

    public FormReservaHorasDAO() throws SQLException {
        this.conexion = ConnectionManager.obtenerConexion();
    }

    public FormReservaHoras ObtenerUsuarios(String email)throws SQLException {
        String sql = "select * from grupo1_registro where email = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            FormReservaHoras FRS = new FormReservaHoras(
                    rs.getString("nombre_completo"),
                    rs.getString("email"),
                    rs.getString("telefono"),
                    rs.getString("pass"), rs.getInt("privilegio")
            );
            return FRS;
        }
        return null;
    }

    public int login(String email,String pass)throws SQLException {
        String sql = "select pass from grupo1_registro where email = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String password=rs.getString("pass");

            if (password.equals(pass)){
                return 1;
            }
        }
        return 0;
    }

    public int is_Admin(String email,String pass)throws SQLException {
        String sql = "select pass,privilegio from grupo1_registro where email = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String password=rs.getString("pass");
            int priv = rs.getInt("privilegio");

            if (password.equals(pass)){
                if (priv==1){
                    return 1;
                }
            }
        }
        return 0;
    }

    public int userExists(String email)throws SQLException {
        String sql = "select email from grupo1_registro where email = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            return 1;
        }
        return 0;
    }


    public void RegistroUsuarios(String Nombre_completo, String Email, String Telefono,String Pass) throws SQLException {
        String sql = "INSERT INTO grupo1_registro (nombre_completo,email, telefono, pass, privilegio) "
                + "values (?, ? , ? , ?, 0)";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1,Nombre_completo);
        ps.setString(2,Email);
        ps.setString(3,Telefono);
        ps.setString(4,Pass);
        ps.executeUpdate();
    }
    public void BorrarPeticion(String correo) throws SQLException {
        String sql = "DELETE FROM grupo1_registro where email = ? ";

        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1,correo);
        ps.executeUpdate();

    }
    public void ActualizarPass(String email,String pass) throws SQLException {
        String sql = "update grupo1_registro " +
                "set pass = ? " +
                "where email = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, pass);
        ps.setString(2, email);
        ps.executeUpdate();

    }
    public void ActualizarTelefono(String email,String telefono) throws SQLException {
        String sql = "update grupo1_registro " +
                "set telefono = ? " +
                "where email = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, telefono);
        ps.setString(2, email);
        ps.executeUpdate();
    }

}
