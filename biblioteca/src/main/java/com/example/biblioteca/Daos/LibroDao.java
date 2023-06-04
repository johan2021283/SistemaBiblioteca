package com.example.biblioteca.Daos;


import com.example.biblioteca.Entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroDao extends JpaRepository<Libro, Long> {
    List<Libro> findByDisponiblesGreaterThan(int i);
}
