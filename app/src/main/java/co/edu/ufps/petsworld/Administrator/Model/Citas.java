package co.edu.ufps.petsworld.Administrator.Model;

public class Citas {

    private String id;
    private String idCita;
    private String idCliente;
    private String idMascota;
    private String imagenMascota;
    private String fecha;
    private String hora;

    public Citas(){

    }

    public Citas(String id, String idCita, String idCliente, String idMascota, String imagenMascota, String fecha, String hora) {
        this.id = id;
        this.idCita = idCita;
        this.idCliente = idCliente;
        this.idMascota = idMascota;
        this.imagenMascota = imagenMascota;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdCita() {
        return idCita;
    }

    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(String idMascota) {
        this.idMascota = idMascota;
    }

    public String getImagenMascota() {
        return imagenMascota;
    }

    public void setImagenMascota(String imagenMascota) {
        this.imagenMascota = imagenMascota;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

}
