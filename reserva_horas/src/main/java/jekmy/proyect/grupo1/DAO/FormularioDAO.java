package jekmy.proyect.grupo1.DAO;

import jekmy.proyect.grupo1.ConnectionManager;
import jekmy.proyect.grupo1.DTO.Formulario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FormularioDAO {
    private Connection conexion;

    public FormularioDAO() throws SQLException {
        this.conexion = ConnectionManager.obtenerConexion();
    }
    public Formulario ObtenerPeticiones(String email) throws SQLException {
        String sql = "select * from grupo1_reservas where email = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            Formulario F = new Formulario(
                    rs.getString("email"),
                    rs.getInt("dia"),
                    rs.getInt("mes"),
                    rs.getInt("anio"),
                    rs.getString("seleccion"),
                    rs.getString("servicio_contratacion"),
                    rs.getString("servicio_actualizacion"),
                    rs.getString("otro")
            );
            return F;
        }
        return null;

    }
    public void IngresoPeticion(Formulario F) throws SQLException {
        String sql = "insert into grupo1_reservas (email, dia, mes, anio, seleccion," +
                "servicio_contratacion, servicio_actualizacion, otro)" +
                "values(?,?,?,?,?,?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, F.getEmail());
        ps.setInt(2,F.getDia());
        ps.setInt(3, F.getMes());
        ps.setInt(4, F.getAnio());
        ps.setString(5,F.getSeleccion());
        ps.setString(6, F.getServicio_contratacion());
        ps.setString(7,F.getServicio_actualizacion());
        ps.setString(8, F.getOtro());

        ps.executeUpdate();

    }
    public void ActualizarDatos(int dia, int mes, int anio,
                                String seleccion, String servicio_contratacion,
                                String servicio_actualizacion, String otro,
                                Formulario f) throws SQLException {
        String sql = "update grupo1_reservas" +
                "set dia = ? and mes = ? and anio = ?" +
                "and seleccion = ? and servicio_contratacion = ? or servicio_actualizacion = ?" +
                "and otro = ? where email = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, f.getDia());
        ps.setInt(2, f.getMes());
        ps.setInt(3, f.getAnio());
        ps.setString(4,f.getSeleccion());
        ps.setString(5, f.getServicio_contratacion());
        ps.setString(6,f.getServicio_actualizacion());
        ps.setString(7,f.getOtro());
        ps.setInt(8,dia);
        ps.setInt(9, mes);
        ps.setInt(10, anio);
        ps.setString(11, seleccion);
        ps.setString(12, servicio_contratacion);
        ps.setString(13, servicio_actualizacion);
        ps.setString(14, otro);
        ps.executeUpdate();

    }

}
