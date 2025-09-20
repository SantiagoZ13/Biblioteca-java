package co.edu.itc.programacion.biblioteca.repositorio;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.itc.programacion.biblioteca.modelo.Computador;

public class RepositorioComputador extends RepositorioRecursoBase<Computador> {

    public RepositorioComputador(){
        super();
    }

    @Override
    public List<Computador> buscarPorCriterio(String criterio) {
        String c = criterio.toLowerCase();
        return listaRecursos.stream()
                .filter(pc -> pc.getNombre().toLowerCase().contains(c) ||
                              pc.getMarca().toLowerCase().contains(c) ||
                              pc.getModelo().toLowerCase().contains(c) ||
                              pc.getTipo().name().toLowerCase().contains(c))
                .collect(Collectors.toList());
    }
}
