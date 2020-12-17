package co.edu.ufps.petsworld.Administrator.Model;

public class Mascotas{

    private String id;
    private String nombre;
    private String raza;
    private String sexo;
    private String edad;
    private String propietario;
    private String imagen;

    public Mascotas(){

    }

    public Mascotas(String id, String nombre, String raza, String sexo, String edad, String propietario, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.sexo = sexo;
        this.edad = edad;
        this.propietario = propietario;
        this.imagen = imagen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}
