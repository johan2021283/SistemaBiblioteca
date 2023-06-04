package com.example.biblioteca.Service;

import com.example.biblioteca.Entity.Prestamo;

import java.util.Date;
import java.util.List;

public interface ServicePrestamo {
    List<Prestamo> obtenerTodosLosPrestamos();

    public  Double obtenerMulta(Long prestamoId);

    Prestamo realizarPrestamo(Long libroId, Long usuarioId);

    void devolverPrestamo(Long prestamoId, Date fechaDevolucion);



}
