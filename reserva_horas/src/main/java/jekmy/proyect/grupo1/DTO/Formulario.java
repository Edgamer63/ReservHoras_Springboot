package jekmy.proyect.grupo1.DTO;



public class Formulario {
    private String email;
    private int dia;
    private int mes;
    private int anio;
    private int hora;
    private int seleccion;
    private int servicio_contratacion;
    private int servicio_actualizacion;
    private int aceptado;

    public Formulario(String email, int dia, int mes, int anio, int hora, int seleccion, int servicio_contratacion, int servicio_actualizacion, int aceptado) {
        this.email = email;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.hora = hora;
        this.seleccion = seleccion;
        this.servicio_contratacion = servicio_contratacion;
        this.servicio_actualizacion = servicio_actualizacion;
        this.aceptado = aceptado;
    }

    @Override
    public String toString() {
        return "Formulario{" +
                "email='" + email + '\'' +
                ", dia=" + dia +
                ", mes=" + mes +
                ", anio=" + anio +
                ", hora=" + hora +
                ", seleccion=" + seleccion +
                ", servicio_contratacion=" + servicio_contratacion +
                ", servicio_actualizacion=" + servicio_actualizacion +
                ", aceptado=" + aceptado +
                '}';
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

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(int seleccion) {
        this.seleccion = seleccion;
    }

    public int getServicio_contratacion() {
        return servicio_contratacion;
    }

    public void setServicio_contratacion(int servicio_contratacion) {
        this.servicio_contratacion = servicio_contratacion;
    }

    public int getServicio_actualizacion() {
        return servicio_actualizacion;
    }

    public void setServicio_actualizacion(int servicio_actualizacion) {
        this.servicio_actualizacion = servicio_actualizacion;
    }

    public int getAceptado() {
        return aceptado;
    }

    public void setAceptado(int aceptado) {
        this.aceptado = aceptado;
    }
}
