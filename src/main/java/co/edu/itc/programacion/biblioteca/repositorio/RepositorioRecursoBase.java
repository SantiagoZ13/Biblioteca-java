package co.edu.itc.programacion.biblioteca.repositorio;

import co.edu.itc.programacion.biblioteca.modelo.Recurso;
import java.util.ArrayList;
import java.util.List;

public abstract class RepositorioRecursoBase<T extends Recurso> implements RepositorioRecurso<T>{
    protected List<T> listaRecursos;

    public RepositorioRecursoBase() {
        this.listaRecursos = new ArrayList<>();
    }

    @Override
    public T guardar(T recurso) {
        listaRecursos.add(recurso);
        return recurso;
    }

    @Override
    public T actualizar(Integer id, T recurso) { 
        for (int i = 0; i < listaRecursos.size(); i++) {
            if (listaRecursos.get(i).getId().equals(id)) {
                listaRecursos.set(i, recurso);
                return recurso;
            }
        }
        throw new IllegalArgumentException("Recurso con id " + id + " no encontrado.");
    }

    @Override
    public boolean eliminar(Integer id) { 
        return listaRecursos.removeIf(r -> r.getId().equals(id));
    }

    @Override
    public T obtener(Integer id) {
        return listaRecursos.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<T> listarTodos() {
        return new ArrayList<>(listaRecursos);
    }

    @Override
    public abstract List<T> buscarPorCriterio(String criterio);
}
