package co.edu.itc.programacion.biblioteca.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Recurso {
    private Integer id;
    private String nombre;
    private LocalDateTime fechaRegistro;

    Recurso(){
        this.fechaRegistro = LocalDateTime.now();
    }
    Recurso(Integer id, String nombre){
        this.id = id;
        this.nombre = nombre;
        this.fechaRegistro = LocalDateTime.now();
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public LocalDateTime getFechaRegistro(){
        return fechaRegistro;
    }
    protected String formatFecha(){
        return fechaRegistro.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    
    @Override
    public abstract String toString();
}
