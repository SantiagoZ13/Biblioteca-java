package co.edu.itc.programacion.biblioteca;

import java.util.List;

import co.edu.itc.programacion.biblioteca.modelo.*;
import co.edu.itc.programacion.biblioteca.servicio.ServicioBiblioteca;

public class ServicioBibliotecaMain {

    public static void main(String[] args) {

        ServicioBiblioteca servicio = new ServicioBiblioteca();

        // Creamos tres recursos de cada tipo
        servicio.agregar(new Libro(1, "El estudiante", "Juan", 2023, "ISBN100"));
        servicio.agregar(new Libro(2, "Kenshi", "Kevin", 2019, "ISBN200"));
        servicio.agregar(new Libro(3, "Kenshi 2", "Santiago", 2020, "ISBN300"));

        servicio.agregar(new Periodico(4, "Periódico1", "El Diario", 2019));
        servicio.agregar(new Periodico(5, "Periódico2", "La Nación", 2021));
        servicio.agregar(new Periodico(6, "Periódico3", "Noticias Hoy", 2022));

        servicio.agregar(new Computador(7, "Computador1", "Dell", "XPS 13", TipoComputador.PORTATIL));
        servicio.agregar(new Computador(8, "Computador2", "HP", "EliteBook", TipoComputador.ESCRITORIO));
        servicio.agregar(new Computador(9, "Computador3", "Lenovo", "ThinkPad", TipoComputador.TABLET));

        System.out.println("========Parcial Programación========");
        System.out.println("=== Recursos creados y agregados ===");
        servicio.listarTodos().forEach(System.out::println);

        // buscamos recursos por el criterio: Kenshi
        System.out.println("\n=== Buscar por criterio: 'Kenshi' ===");
        List<Recurso> encontrados = servicio.buscarPorCriterio("Kenshi");
        encontrados.forEach(System.out::println);

        // tomamos la primera coincidencia y le cambiamos el nombre al primero
        if (!encontrados.isEmpty()) {
            Recurso primero = encontrados.get(0);
            System.out.println("\nActualizando nombre del recurso con id " + primero.getId());
            primero.setNombre(primero.getNombre() + " (Actualizado)");
            servicio.modificar(primero.getId(), primero);
        }

        System.out.println("\n=== Recursos después de actualización ===");
        servicio.listarTodos().forEach(System.out::println);

        // Buscamos un recurso y lo eliminamos
        System.out.println("\n=== Buscar y eliminar por criterio: 'EliteBook' ===");
        List<Recurso> paraEliminar = servicio.buscarPorCriterio("EliteBook");
        if (!paraEliminar.isEmpty()) {
            Recurso aEliminar = paraEliminar.get(0);
            boolean eliminado = false;

            if (aEliminar instanceof Libro) {
                eliminado = servicio.eliminarLibro(aEliminar.getId());
            } else if (aEliminar instanceof Periodico) {
                eliminado = servicio.eliminarPeriodico(aEliminar.getId());
            } else if (aEliminar instanceof Computador) {
                eliminado = servicio.eliminarComputador(aEliminar.getId());
            }

            System.out.println("Recurso eliminado: " + eliminado);
        }

        // listamos todos los recursos
        System.out.println("\n=== Listado final de recursos ===");
        servicio.listarTodos().forEach(System.out::println);
    }
}