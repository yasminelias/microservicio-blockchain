package ar.edu.utn.microservicio_blockchain;

public class NotaDTO {
    private String dni;
    private String materia;
    private String nota;
    private String fecha;

    // Getters y Setters
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getMateria() { return materia; }
    public void setMateria(String materia) { this.materia = materia; }

    public String getNota() { return nota; }
    public void setNota(String nota) { this.nota = nota; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
}
