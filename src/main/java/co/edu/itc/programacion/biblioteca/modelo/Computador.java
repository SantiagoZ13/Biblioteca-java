package co.edu.itc.programacion.biblioteca.modelo;

public class Computador extends Recurso {
    private String marca;
    private String modelo;
    private TipoComputador tipo;

    public Computador() {
        super();
    }

    public Computador(Integer id, String nombre, String marca, String modelo, TipoComputador tipo) {
        super(id, nombre);
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
    }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public TipoComputador getTipo() { return tipo; }
    public void setTipo(TipoComputador tipo) { this.tipo = tipo; }

    @Override
    public String toString() {
        return "Computador [id=" + getId() +
               ", nombre=" + getNombre() +
               ", marca=" + marca +
               ", modelo=" + modelo +
               ", tipo=" + tipo +
               ", fechaRegistro=" + formatFecha() + "]";
    }
}
