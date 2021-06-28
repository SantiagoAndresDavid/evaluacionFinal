package dominio;

public class Posgrado {
    private int NoDocumento;
    private String nombre;
    private String apellido;
    private String ProgramaPosgrado;
    private int Semestre;
    private double PromedioSemestre;

    public Posgrado() {
    }

    public Posgrado(int noDocumento, String nombre, String apellido, String programaPosgrado, int semestre, double promedioSemestre) {
        NoDocumento = noDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        ProgramaPosgrado = programaPosgrado;
        Semestre = semestre;
        PromedioSemestre = promedioSemestre;
    }

    public int getNoDocumento() {
        return NoDocumento;
    }

    public void setNoDocumento(int noDocumento) {
        NoDocumento = noDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getProgramaPosgrado() {
        return ProgramaPosgrado;
    }

    public void setProgramaPosgrado(String programaPosgrado) {
        ProgramaPosgrado = programaPosgrado;
    }

    public int getSemestre() {
        return Semestre;
    }

    public void setSemestre(int semestre) {
        Semestre = semestre;
    }

    public double getPromedioSemestre() {
        return PromedioSemestre;
    }

    public void setPromedioSemestre(double promedioSemestre) {
        PromedioSemestre = promedioSemestre;
    }

    public String getDataText(){
        return this.NoDocumento+";"+this.nombre+";"+this.apellido+";"+this.ProgramaPosgrado+";"+this.Semestre+";"+this.PromedioSemestre;
    }

    @Override
    public String toString() {
        return "Posgrado{" +
                "NoDocumento=" + NoDocumento +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", ProgramaPosgrado='" + ProgramaPosgrado + '\'' +
                ", Semestre=" + Semestre +
                ", PromedioSemestre=" + PromedioSemestre +
                '}';
    }
}
