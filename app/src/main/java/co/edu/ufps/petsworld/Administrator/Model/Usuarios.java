package co.edu.ufps.petsworld.Administrator.Model;

public class Usuarios {

    private String id;
    private String identificacion;
    private String nombre;
    private String sexo;
    private String correo;
    private String telefono;
    private String imagen;

    public Usuarios(){

    }

    public Usuarios(String id, String identificacion, String nombre, String sexo, String correo, String telefono, String imagen) {
        this.id = id;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.sexo = sexo;
        this.correo = correo;
        this.telefono = telefono;
        this.imagen = imagen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}
