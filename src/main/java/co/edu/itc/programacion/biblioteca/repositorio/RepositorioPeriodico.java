package co.edu.itc.programacion.biblioteca.repositorio;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.itc.programacion.biblioteca.modelo.Periodico;

public class RepositorioPeriodico extends RepositorioRecursoBase<Periodico> {

    public RepositorioPeriodico(){
        super();
    }

    @Override
    public List<Periodico> buscarPorCriterio(String criterio) {
        String c = criterio.toLowerCase();
        return listaRecursos.stream()
                .filter(p -> p.getNombre().toLowerCase().contains(c) ||
                             p.getEditorial().toLowerCase().contains(c) ||
                             String.valueOf(p.getAnio()).contains(c))
                .collect(Collectors.toList());
    }
}
