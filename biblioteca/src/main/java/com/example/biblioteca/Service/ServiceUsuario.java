package com.example.biblioteca.Service;

import com.example.biblioteca.Entity.Libro;
import com.example.biblioteca.Entity.Usuario;

import java.util.List;

public interface ServiceUsuario {
    List<Usuario> obtenerTodosLosUsuarios();
    Usuario obtenerUsuarioPorId(Long id);
    void guardarUsuario(Usuario usuario);
    void actualizarUsuario(Long id, Usuario usuario);
    void eliminarUsuario(Long id);

}
