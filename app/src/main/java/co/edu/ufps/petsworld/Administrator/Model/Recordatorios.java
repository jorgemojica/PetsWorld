package co.edu.ufps.petsworld.Administrator.Model;

public class Recordatorios {

    private String id;
    private String asunto;
    private String hora;
    private String fecha;
    private String mensaje;
    private String imagen;

    public Recordatorios(){

    }

    public Recordatorios(String id, String asunto, String hora, String fecha, String mensaje, String imagen) {
        this.id = id;
        this.asunto = asunto;
        this.hora = hora;
        this.fecha = fecha;
        this.mensaje = mensaje;
        this.imagen = imagen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}
