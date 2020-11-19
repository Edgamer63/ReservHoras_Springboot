package jekmy.proyect.grupo1.DTO;

import jekmy.proyect.grupo1.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class FormReservaHoras {
    private String nombre_completo;
    private String email;
    private String telefono;
    private String pass;
    private Integer privilegio;

    public FormReservaHoras(String nombre_completo, String email, String telefono, String pass, Integer privilegio) {
        this.nombre_completo = nombre_completo;
        this.email = email;
        this.telefono = telefono;
        this.pass = pass;
        this.privilegio = privilegio;


    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Integer getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(Integer privilegio) {
        this.privilegio = privilegio;
    }
    @Override
    public int hashCode() {
        return Objects.hash(nombre_completo, email, telefono, pass, privilegio);
    }

    @Override
    public String toString() {
        return "FormReservaHoras{" +
                "nombre_completo='" + nombre_completo + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", pass='" + pass + '\'' +
                ", privilegio=" + privilegio +
                '}';
    }
    public static List<FormReservaHoras> resultado = new LinkedList<>();
    static {
        Connection connection;
        try {
            ConnectionManager.obtenerConexion();
        } catch (SQLException e) {
            System.out.println (e);
        }
    }

}