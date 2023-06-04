package com.example.biblioteca.Service;

import com.example.biblioteca.Daos.UsuarioDao;
import com.example.biblioteca.Entity.Libro;
import com.example.biblioteca.Entity.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUsuarioImpl implements ServiceUsuario {
    private final UsuarioDao usuarioDao;

    public ServiceUsuarioImpl(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }


    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioDao.findAll();
    }

    @Override
    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuarioDao.save(usuario);

    }

    @Override
    public void actualizarUsuario(Long id, Usuario usuario) {
        if (usuarioDao.existsById(id)){
            usuario.setId(id);
            usuarioDao.save(usuario);
        }

    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioDao.deleteById(id);
    }
}
