package co.edu.itc.programacion.biblioteca.modelo;

public class Libro extends Recurso {
    private String autor;
    private Integer anio;
    private String isbn;

    public Libro(){
        super();
    }

    public Libro(Integer id, String nombre, String autor, Integer anio, String isbn){
        super(id, nombre);
        this.autor = autor;
        this.anio = anio;
        this.isbn = isbn;
    }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public Integer getAnio() { return anio; }
    public void setAnio(Integer anio) { this.anio = anio; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    @Override
    public String toString() {
        return "Libro [id=" + getId() +
               ", nombre=" + getNombre() +
               ", autor=" + autor +
               ", anio=" + anio +
               ", isbn=" + isbn +
               ", fechaRegistro=" + formatFecha() + "]";
    }
}
