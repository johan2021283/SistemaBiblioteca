package com.example.biblioteca.Service;

import com.example.biblioteca.Daos.LibroDao;
import com.example.biblioteca.Entity.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceLibroImpl implements ServiceLibro{
    private final LibroDao libroDao;

    @Autowired
    public ServiceLibroImpl(LibroDao libroDao){
        this.libroDao = libroDao;
    }
    @Override
    public List<Libro> obtenerTodosLosLibros() {
        return libroDao.findAll();
    }

    @Override
    public Libro obtenerLibroPorId(Long id) {
        return libroDao.findById(id).orElse(null);
    }

    @Override
    public void guardarLibro(Libro libro) {
        libroDao.save(libro);

    }

    @Override
    public void eliminarLibro(Long id) {
        libroDao.deleteById(id);

    }

    @Override
    public void actualizarLibro(Long id, Libro libro) {
        if (libroDao.existsById(id)){
            libro.setId(id);
            libroDao.save(libro);
        }
    }

    @Override
    public List<Libro> obtenerLibrosDisponibles() {
        return libroDao.findByDisponiblesGreaterThan(0);
    }
}
