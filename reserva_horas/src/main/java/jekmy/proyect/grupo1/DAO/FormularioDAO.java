package jekmy.proyect.grupo1.DAO;

import jekmy.proyect.grupo1.ConnectionManager;
import jekmy.proyect.grupo1.DTO.Formulario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FormularioDAO {
    private Connection conexion;

    public FormularioDAO() throws SQLException {
        this.conexion = ConnectionManager.obtenerConexion();
    }


    public List<Formulario> ObtenerTodasPeticiones() throws SQLException {
        List<Formulario> ret = new ArrayList<Formulario>();

        String sql = "select * from grupo1_reservas";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            Formulario F = new Formulario(
                    rs.getString("email"),
                    rs.getInt("dia"),
                    rs.getInt("mes"),
                    rs.getInt("anio"),
                    rs.getInt("hora"),
                    rs.getInt("seleccion"),
                    rs.getInt("servicio_contratacion"),
                    rs.getInt("servicio_actualizacion"),
                    rs.getInt("aceptado")
            );
            ret.add(F);
        }
        return ret;

    }

    public List<Formulario> ObtenerTodasPeticionesNoAceptadas() throws SQLException {
        List<Formulario> ret = new ArrayList<Formulario>();

        String sql = "select * from grupo1_reservas where aceptado = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, 0);

        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            Formulario F = new Formulario(
                    rs.getString("email"),
                    rs.getInt("dia"),
                    rs.getInt("mes"),
                    rs.getInt("anio"),
                    rs.getInt("hora"),
                    rs.getInt("seleccion"),
                    rs.getInt("servicio_contratacion"),
                    rs.getInt("servicio_actualizacion"),
                    rs.getInt("aceptado")
            );
            ret.add(F);
        }
        return ret;

    }

    public List<Formulario> ObtenerTodasPeticionesAceptadas() throws SQLException {
        List<Formulario> ret = new ArrayList<Formulario>();

        String sql = "select * from grupo1_reservas where aceptado = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, 1);

        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            Formulario F = new Formulario(
                    rs.getString("email"),
                    rs.getInt("dia"),
                    rs.getInt("mes"),
                    rs.getInt("anio"),
                    rs.getInt("hora"),
                    rs.getInt("seleccion"),
                    rs.getInt("servicio_contratacion"),
                    rs.getInt("servicio_actualizacion"),
                    rs.getInt("aceptado")
            );
            ret.add(F);
        }
        return ret;

    }

    public int obtenerHora(int hora,int dia, int mes, int anio) throws SQLException {
        String sql = "select aceptado from grupo1_reservas where hora = ? and dia = ? and mes = ? and anio = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, hora);
        ps.setInt(2, dia);
        ps.setInt(3, mes);
        ps.setInt(4, anio);

        int ret = 0;
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            ret=1;
        }
        return ret;
    }
	

    public int aceptarHora(int hora,int dia, int mes, int anio) throws SQLException {
        String sql = "update grupo1_reservas set aceptado = ? where hora = ? and dia = ? and mes = ? and anio = ?";

        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, 1);
        ps.setInt(2, hora);
        ps.setInt(3, dia);
        ps.setInt(4, mes);
        ps.setInt(5, anio);

        ps.executeUpdate();
        return 1;
    }

    public List<Formulario> ObtenerPeticiones(String email) throws SQLException {
        List<Formulario> ret = new ArrayList<Formulario>();

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
                    rs.getInt("hora"),
                    rs.getInt("seleccion"),
                    rs.getInt("servicio_contratacion"),
                    rs.getInt("servicio_actualizacion"),
                    rs.getInt("aceptado")
            );
            ret.add(F);
        }
        return ret;

    }

    public void IngresoPeticion(String correo,int dia, int mes, int anio, int hora,
                                int seleccion, int servicio_contratacion,
                                int servicio_actualizacion) throws SQLException {
        String sql = "insert into grupo1_reservas (email, dia, mes, anio, hora ,seleccion," +
                "servicio_contratacion, servicio_actualizacion, aceptado)" +
                " values(?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, correo);
        ps.setInt(2,dia);
        ps.setInt(3, mes);
        ps.setInt(4, anio);
        ps.setInt(5, hora);
        ps.setInt(6,seleccion);
        ps.setInt(7, servicio_contratacion);
        ps.setInt(8, servicio_actualizacion);
        ps.setInt(9, 0);

        ps.execute();
    }


}
