package mx.edu.utez.registroalumnos.Model;

public class Persona {
    private int id_persona;
    private String nombre;
    private String appellido_paterno;
    private String appellido_materno;
    private int edad;
    private String matricula;
    private String correo;
    private String sexo;

    public Persona() {
    }

    public Persona( int id_persona,String nombre, String appellido_paterno, String appellido_materno, int edad, String matricula, String sexo, String correo) {
        this.nombre = nombre;
        this.id_persona = id_persona;
        this.appellido_paterno = appellido_paterno;
        this.appellido_materno = appellido_materno;
        this.edad = edad;
        this.matricula = matricula;
        this.sexo = sexo;
        this.correo = correo;
    }

    @Override
    public String toString() {
        return  id_persona + ' ' +nombre + ' ' + appellido_paterno + ' ' + appellido_materno+ ' ' +  edad + ' ' + matricula + ' ' + correo + ' ' + sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAppellido_paterno() {
        return appellido_paterno;
    }

    public void setAppellido_paterno(String appellido_paterno) {
        this.appellido_paterno = appellido_paterno;
    }

    public String getAppellido_materno() {
        return appellido_materno;
    }

    public void setAppellido_materno(String appellido_materno) {
        this.appellido_materno = appellido_materno;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }


}
