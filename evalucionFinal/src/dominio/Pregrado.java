package dominio;

public class Pregrado {
    private int NoDocumento;
    private String nombre;
    private String apellido;
    private String ProgramaPosgrado;
    private int Semestre;
    private double Corte1;
    private double Corte2;
    private double Corte3;

    public Pregrado() {
    }

    public Pregrado(int noDocumento, String nombre, String apellido, String programaPosgrado, int semestre, double corte1, double corte2, double corte3) {
        NoDocumento = noDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        ProgramaPosgrado = programaPosgrado;
        Semestre = semestre;
        Corte1 = corte1;
        Corte2 = corte2;
        Corte3 = corte3;
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

    public double getCorte1() {
        return Corte1;
    }

    public void setCorte1(double corte1) {
        Corte1 = corte1;
    }

    public double getCorte2() {
        return Corte2;
    }

    public void setCorte2(double corte2) {
        Corte2 = corte2;
    }

    public double getCorte3() {
        return Corte3;
    }

    public void setCorte3(double corte3) {
        Corte3 = corte3;
    }

    public String getDataText(){
        return this.NoDocumento+";"+this.nombre+";"+this.apellido+";"+this.ProgramaPosgrado+";"+this.Semestre+";"+this.Corte1+";"+this.Corte2+";"+this.Corte3;
    }

    @Override
    public String toString() {
        return "Pregrado{" +
                "NoDocumento=" + NoDocumento +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", ProgramaPosgrado='" + ProgramaPosgrado + '\'' +
                ", Semestre=" + Semestre +
                ", Corte1=" + Corte1 +
                ", Corte2=" + Corte2 +
                ", Corte3=" + Corte3 +
                '}';
    }
}
