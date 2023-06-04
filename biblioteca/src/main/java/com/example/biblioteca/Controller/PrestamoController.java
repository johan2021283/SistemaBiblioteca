package com.example.biblioteca.Controller;

import com.example.biblioteca.Entity.Prestamo;
import com.example.biblioteca.Service.ServicePrestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

    private final ServicePrestamo servicePrestamo;

    @Autowired
    public PrestamoController(ServicePrestamo servicePrestamo) {
        this.servicePrestamo = servicePrestamo;
    }
    @GetMapping
    public List<Prestamo> obtenerPrestamos(){
        return servicePrestamo.obtenerTodosLosPrestamos();
    }

    @GetMapping("/{prestamoId}/multa")
    public Double obtenerMulta(@PathVariable Long prestamoId){
        return servicePrestamo.obtenerMulta(prestamoId);
    }

    @PostMapping("/{libroId}/{usuarioId}")
    public Prestamo realizarPrestamo(@PathVariable Long libroId, @PathVariable Long usuarioId){
        return servicePrestamo.realizarPrestamo(libroId, usuarioId);

    }


    @PutMapping("/{prestamoId}")
    public void devolverPrestamo(@PathVariable Long prestamoId, @RequestBody Date fechaDevolucion){
        servicePrestamo.devolverPrestamo(prestamoId, fechaDevolucion);
    }


}
