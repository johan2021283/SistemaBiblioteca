package com.example.biblioteca.Service;


import com.example.biblioteca.Entity.Libro;

import java.util.List;

public interface ServiceLibro {
    List<Libro> obtenerTodosLosLibros();
    Libro obtenerLibroPorId(Long id);
    void guardarLibro(Libro libro);
    void eliminarLibro(Long id);

    void actualizarLibro(Long id, Libro libro);
    List<Libro> obtenerLibrosDisponibles();

}
