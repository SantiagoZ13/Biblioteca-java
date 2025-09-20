package co.edu.itc.programacion.biblioteca.repositorio;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.itc.programacion.biblioteca.modelo.Libro;

public class RepositorioLibro extends RepositorioRecursoBase<Libro> {

    public RepositorioLibro(){
        super();
    }

    @Override
    public List<Libro> buscarPorCriterio(String criterio) {
        String c = criterio.toLowerCase();
        return listaRecursos.stream()
                .filter(l -> l.getNombre().toLowerCase().contains(c) ||
                             l.getAutor().toLowerCase().contains(c) ||
                             l.getIsbn().toLowerCase().contains(c) ||
                             String.valueOf(l.getAnio()).contains(c))
                .collect(Collectors.toList());
    }
}
