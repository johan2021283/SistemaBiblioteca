package com.example.biblioteca.Controller;

import com.example.biblioteca.Entity.Libro;
import com.example.biblioteca.Entity.Usuario;
import com.example.biblioteca.Service.ServiceUsuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final ServiceUsuario serviceUsuario;

    public UsuarioController(ServiceUsuario serviceUsuario) {
        this.serviceUsuario = serviceUsuario;
    }
    @GetMapping
    public List<Usuario> obtenertodosUsuarios(){
        return serviceUsuario.obtenerTodosLosUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario obtnerPoId(@PathVariable Long id){
        return serviceUsuario.obtenerUsuarioPorId(id);
    }
    @PostMapping
    public void guardarUsuario(@RequestBody Usuario usuario){
        serviceUsuario.guardarUsuario(usuario);
    }

    @PutMapping("/{id}")
    public void actualizarPrestamo(@PathVariable Long id, @RequestBody Usuario usuario){
        serviceUsuario.actualizarUsuario(id, usuario);
    }


    @DeleteMapping("/{id}")
    public void elimiarUsuario(@PathVariable Long id){
        serviceUsuario.eliminarUsuario(id);
    }
}
