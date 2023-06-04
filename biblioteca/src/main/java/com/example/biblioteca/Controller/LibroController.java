package com.example.biblioteca.Controller;

import com.example.biblioteca.Entity.Libro;
import com.example.biblioteca.Service.ServiceLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {
    private final ServiceLibro serviceLibro;

    @Autowired

    public LibroController(ServiceLibro serviceLibro) {
        this.serviceLibro = serviceLibro;
    }
    @GetMapping
    public List<Libro> obtenertodosLibros(){
        return serviceLibro.obtenerTodosLosLibros();
    }

    @GetMapping("/{id}")
    public Libro obtnerPoId(@PathVariable Long id){
        return serviceLibro.obtenerLibroPorId(id);
    }
    @PostMapping
    public void guardarLibro(@RequestBody Libro libro){
        serviceLibro.guardarLibro(libro);
    }
    @PutMapping(value = "/{id}")
    public void actualizarLibro(@PathVariable Long id,@RequestBody Libro libro){
        serviceLibro.actualizarLibro(id, libro);
    }


    @DeleteMapping("/{id}")
    public void elimiarLibro(@PathVariable Long id){
        serviceLibro.eliminarLibro(id);
    }
    @GetMapping("/disponibles")
    public List<Libro> librosDisponibles(){
        return serviceLibro.obtenerLibrosDisponibles();
    }
}
