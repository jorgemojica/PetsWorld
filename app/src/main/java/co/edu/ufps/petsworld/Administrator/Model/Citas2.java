package co.edu.ufps.petsworld.Administrator.Model;

public class Citas2 {

    private String id;
    private String idCita;
    private String idCliente;
    private String idMascota;

    public Citas2(){

    }

    public Citas2(String id, String idCita, String idCliente, String idMascota) {
        this.id = id;
        this.idCita = idCita;
        this.idCliente = idCliente;
        this.idMascota = idMascota;
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

}
