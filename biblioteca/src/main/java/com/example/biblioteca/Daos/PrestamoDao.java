package com.example.biblioteca.Daos;

import com.example.biblioteca.Entity.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestamoDao extends JpaRepository<Prestamo, Long> {
}
