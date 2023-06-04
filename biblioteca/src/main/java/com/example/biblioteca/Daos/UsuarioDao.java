package com.example.biblioteca.Daos;

import com.example.biblioteca.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {
}
