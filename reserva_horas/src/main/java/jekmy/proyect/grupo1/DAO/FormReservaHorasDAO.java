package jekmy.proyect.grupo1.DAO;

import jekmy.proyect.grupo1.ConnectionManager;
import jekmy.proyect.grupo1.DTO.Correo_body;
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
    public void RegistroUsuarios(FormReservaHoras F) throws SQLException {
        String sql = "INSERT INTO grupo1_registro (nombre_completo,email, telefono, pass, privilegio) "
                + "values (?, ? , ? , ?, ?)";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1,F.getNombre_completo());
        ps.setString(2, F.getEmail());
        ps.setString(3,F.getTelefono());
        ps.setString(4,F.getPass());
        ps.setInt(5,F.getPrivilegio());

        ps.executeUpdate();



    }
    public void BorrarPeticion(Correo_body F) throws SQLException {
        String sql = "DELETE FROM grupo1_registro where email = ? ";

        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1,F.getCorreo());
        ps.executeUpdate();

    }
    public void ActualizarPass(String pass, FormReservaHoras F) throws SQLException {
        String sql = "update grupo1_registro " +
                "set pass = ? " +
                "where pass = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, F.getPass());
        ps.setString(2, pass);
        ps.executeUpdate();

    }
    public void ActualizarTelefono(String telefono, FormReservaHoras F) throws SQLException {
        String sql = "update grupo1_registro " +
                "set telefono = ? " +
                "where telefono = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, F.getTelefono());
        ps.setString(2, telefono);
        ps.executeUpdate();
    }

}
