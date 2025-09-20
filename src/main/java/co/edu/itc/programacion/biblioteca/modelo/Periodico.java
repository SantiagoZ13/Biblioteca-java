package co.edu.itc.programacion.biblioteca.modelo;

public class Periodico extends Recurso{
    private String editorial;
    private Integer anio;

    // Constructor vacío
    public Periodico() {
        super();
    }

    public Periodico(Integer id, String nombre, String editorial, Integer anio) {
        super(id, nombre);
        this.editorial = editorial;
        this.anio = anio;
    }

    public String getEditorial() { return editorial; }
    public void setEditorial(String editorial) { this.editorial = editorial; }

    public Integer getAnio() { return anio; }
    public void setAnio(Integer anio) { this.anio = anio; }

    @Override
    public String toString() {
        return "Periodico [id=" + getId() +
               ", nombre=" + getNombre() +
               ", editorial=" + editorial +
               ", anio=" + anio +
               ", fechaRegistro=" + formatFecha() + "]";
    }
}
