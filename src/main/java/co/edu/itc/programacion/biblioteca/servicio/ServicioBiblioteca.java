package co.edu.itc.programacion.biblioteca.servicio;

import java.util.ArrayList;
import java.util.List;

import co.edu.itc.programacion.biblioteca.modelo.*;
import co.edu.itc.programacion.biblioteca.repositorio.*;

public class ServicioBiblioteca {

    private RepositorioLibro repositorioLibro;
    private RepositorioPeriodico repositorioPeriodico;
    private RepositorioComputador repositorioComputador;

    public ServicioBiblioteca() {
        this.repositorioLibro = new RepositorioLibro();
        this.repositorioPeriodico = new RepositorioPeriodico();
        this.repositorioComputador = new RepositorioComputador();
    }

    public Recurso agregar(Recurso recurso){
        validarNombre(recurso.getNombre());
        if(recurso instanceof Libro){
            return repositorioLibro.guardar((Libro) recurso);
        }else if(recurso instanceof Periodico){
            return repositorioPeriodico.guardar((Periodico) recurso);
        }else if(recurso instanceof Computador){
            return repositorioComputador.guardar((Computador) recurso);
        }
        throw new IllegalArgumentException("Tipo de recurso no soportado.");
    }

    public Recurso modificar(Integer id, Recurso recurso){
        validarNombre(recurso.getNombre());
        if (recurso instanceof Libro) {
            return repositorioLibro.actualizar(id, (Libro) recurso);
        } else if (recurso instanceof Periodico) {
            return repositorioPeriodico.actualizar(id, (Periodico) recurso);
        } else if (recurso instanceof Computador) {
            return repositorioComputador.actualizar(id, (Computador) recurso);
        }
        throw new IllegalArgumentException("Tipo de recurso no soportado.");
    }

    public boolean eliminar(Integer id, Recurso recurso) {
        if (recurso instanceof Libro) {
            return repositorioLibro.eliminar(id);
        } else if (recurso instanceof Periodico) {
            return repositorioPeriodico.eliminar(id);
        } else if (recurso instanceof Computador) {
            return repositorioComputador.eliminar(id);
        }
        throw new IllegalArgumentException("Tipo de recurso no soportado.");
    }

    public boolean eliminarLibro(Integer id) {
        return repositorioLibro.eliminar(id);
    }

    public boolean eliminarPeriodico(Integer id) {
        return repositorioPeriodico.eliminar(id);
    }

    public boolean eliminarComputador(Integer id) {
        return repositorioComputador.eliminar(id);
    }

    public Libro obtenerLibro(Integer id) {
        return repositorioLibro.obtener(id);
    }

    public Periodico obtenerPeriodico(Integer id) {
        return repositorioPeriodico.obtener(id);
    }

    public Computador obtenerComputador(Integer id) {
        return repositorioComputador.obtener(id);
    }

    public List<Recurso> listarTodos() {
        List<Recurso> todos = new ArrayList<>();
        todos.addAll(repositorioLibro.listarTodos());
        todos.addAll(repositorioPeriodico.listarTodos());
        todos.addAll(repositorioComputador.listarTodos());
        return todos;
    }

    public List<Recurso> buscarPorCriterio(String criterio) {
        List<Recurso> resultados = new ArrayList<>();
        resultados.addAll(repositorioLibro.buscarPorCriterio(criterio));
        resultados.addAll(repositorioPeriodico.buscarPorCriterio(criterio));
        resultados.addAll(repositorioComputador.buscarPorCriterio(criterio));
        return resultados;
    }

    private void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
    }
}
