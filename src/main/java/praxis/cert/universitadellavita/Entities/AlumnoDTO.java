package praxis.cert.universitadellavita.Entities;

public class AlumnoDTO {
    private String alumnoNombre;
    private String alumnoApellido;
    private String alumnoEmail;
    private String cursoDescripcion;
    private Double promedioNotas;

    public AlumnoDTO() {
    }

    public AlumnoDTO(String alumnoNombre, String alumnoApellido, String alumnoEmail, String cursoDescripcion, Double promedioNotas) {
        this.alumnoNombre = alumnoNombre;
        this.alumnoApellido = alumnoApellido;
        this.alumnoEmail = alumnoEmail;
        this.cursoDescripcion = cursoDescripcion;
        this.promedioNotas = promedioNotas;
    }

    public String getAlumnoNombre() {
        return alumnoNombre;
    }

    public void setAlumnoNombre(String alumnoNombre) {
        this.alumnoNombre = alumnoNombre;
    }

    public String getAlumnoApellido() {
        return alumnoApellido;
    }

    public void setAlumnoApellido(String alumnoApellido) {
        this.alumnoApellido = alumnoApellido;
    }

    public String getAlumnoEmail() {
        return alumnoEmail;
    }

    public void setAlumnoEmail(String alumnoEmail) {
        this.alumnoEmail = alumnoEmail;
    }

    public String getCursoDescripcion() {
        return cursoDescripcion;
    }

    public void setCursoDescripcion(String cursoDescripcion) {
        this.cursoDescripcion = cursoDescripcion;
    }

    public Double getPromedioNotas() {
        return promedioNotas;
    }

    public void setPromedioNotas(Double promedioNotas) {
        this.promedioNotas = promedioNotas;
    }
}
