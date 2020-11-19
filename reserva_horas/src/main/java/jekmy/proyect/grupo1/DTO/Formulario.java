package jekmy.proyect.grupo1.DTO;



public class Formulario {
    private String email;
    private int dia;
    private int mes;
    private int anio;
    private String seleccion;
    private String servicio_contratacion;
    private String servicio_actualizacion;
    private String otro;

    public Formulario(String email, int dia, int mes, int anio, String seleccion, String servicio_contratacion, String servicio_actualizacion, String otro) {
        this.email = email;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.seleccion = seleccion;
        this.servicio_contratacion = servicio_contratacion;
        this.servicio_actualizacion = servicio_actualizacion;
        this.otro = otro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(String seleccion) {
        this.seleccion = seleccion;
    }

    public String getServicio_contratacion() {
        return servicio_contratacion;
    }

    public void setServicio_contratacion(String servicio_contratacion) {
        this.servicio_contratacion = servicio_contratacion;
    }

    public String getServicio_actualizacion() {
        return servicio_actualizacion;
    }

    public void setServicio_actualizacion(String servicio_actualizacion) {
        this.servicio_actualizacion = servicio_actualizacion;
    }

    public String getOtro() {
        return otro;
    }

    public void setOtro(String otro) {
        this.otro = otro;
    }

    @Override
    public String toString() {
        return "Formulario{" +
                "email='" + email + '\'' +
                ", dia=" + dia +
                ", mes=" + mes +
                ", anio=" + anio +
                ", seleccion='" + seleccion + '\'' +
                ", servicio_contratacion='" + servicio_contratacion + '\'' +
                ", servicio_actualizacion='" + servicio_actualizacion + '\'' +
                ", otro='" + otro + '\'' +
                '}';
    }
}
