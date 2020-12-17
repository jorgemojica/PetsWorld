package co.edu.ufps.petsworld.Administrator.Model;

public class Clientes extends Usuarios{

    private String mascotas;
    private String direccion;

    public Clientes(){

    }

    public Clientes(String id, String identificacion, String nombre, String sexo, String correo, String telefono, String imagen, String mascotas, String direccion) {
        super(id, identificacion, nombre, sexo, correo, telefono, imagen);
        this.mascotas = mascotas;
        this.direccion = direccion;
    }

    public String getMascotas() {
        return mascotas;
    }

    public void setMascotas(String mascotas) {
        this.mascotas = mascotas;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
