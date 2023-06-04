package com.example.biblioteca.Service;

import com.example.biblioteca.Daos.LibroDao;
import com.example.biblioteca.Daos.PrestamoDao;
import com.example.biblioteca.Daos.UsuarioDao;
import com.example.biblioteca.Entity.Libro;
import com.example.biblioteca.Entity.Prestamo;
import com.example.biblioteca.Entity.Usuario;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class ServicePrestamoImpl implements ServicePrestamo {

    private final PrestamoDao prestamoDao;
    private final LibroDao libroDao;
    private final UsuarioDao usuarioDao;

    public ServicePrestamoImpl(PrestamoDao prestamoDao, LibroDao libroDao, UsuarioDao usuarioDao) {
        this.prestamoDao = prestamoDao;
        this.libroDao = libroDao;
        this.usuarioDao = usuarioDao;
    }

    @Override
    public List<Prestamo> obtenerTodosLosPrestamos() {
        return prestamoDao.findAll();
    }

    @Override
    public Double obtenerMulta(Long prestamoId) {
        Prestamo prestamo = prestamoDao.findById(prestamoId)
                .orElseThrow(()-> new NoSuchElementException("El prestamo con el id" + prestamoId + "no existe"));
        return prestamo.getMulta();
    }

    @Override
    public Prestamo realizarPrestamo(Long libroId, Long usuarioId) {
        Libro libro = libroDao.findById(libroId)
                .orElseThrow(() -> new NoSuchElementException("El libro con Id " + libroId + " no existe"));

        if (libro.getDisponibles() > 0) {
            libro.setDisponibles(libro.getDisponibles() - 1);
            libroDao.save(libro);

            Usuario usuario = usuarioDao.findById(usuarioId)
                    .orElseThrow(()-> new NoSuchElementException("El usuario con id" + usuarioId + "no existe"));

            Date fechaPrestamo = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaPrestamo);
            calendar.add(Calendar.DAY_OF_MONTH, 7); // Establecer la fecha de devolución en una semana
            Date fechaDevolucion = calendar.getTime();

            Prestamo prestamo = new Prestamo(libroId, fechaPrestamo, fechaDevolucion);
            prestamo.setUsuarioId(usuarioId);
            return prestamoDao.save(prestamo);

        }

        return null;
    }
    @Override
    public void devolverPrestamo(Long prestamoId, Date fechaDevolucion) {
        Prestamo prestamo = prestamoDao.findById(prestamoId)
                .orElseThrow(() -> new NoSuchElementException("El prestamo con Id " + prestamoId + " no existe"));

        Libro libro = libroDao.findById(prestamo.getLibroId())
                .orElseThrow(() -> new NoSuchElementException("El libro asociado al prestamo no existe"));

        libro.setDisponibles(libro.getDisponibles() + 1);
        libroDao.save(libro);

        prestamo.setFechaDevolucion(Calendar.getInstance().getTime());
        prestamoDao.delete(prestamo);

        Date fechaLimite = prestamo.getFechaDevolucion();
        if (fechaDevolucion.after(fechaLimite)){
            long diff = fechaDevolucion.getTime()-fechaLimite.getTime();
            long diffDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

            //calcular la multa
            double multa = diffDays * 5.0;
            prestamo.setMulta(multa);
            prestamoDao.save(prestamo);
        }

}
}
