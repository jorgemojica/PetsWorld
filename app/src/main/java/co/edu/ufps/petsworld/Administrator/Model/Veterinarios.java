package co.edu.ufps.petsworld.Administrator.Model;

public class Veterinarios extends Usuarios{

    private String especialidad;
    private String consultorio;

    public Veterinarios(){

    }

    public Veterinarios(String id, String identificacion, String nombre, String sexo, String correo, String telefono, String especialidad, String consultorio, String imagen) {
        super(id, identificacion, nombre, sexo, correo, telefono, imagen);
        this.especialidad = especialidad;
        this.consultorio = consultorio;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

}
