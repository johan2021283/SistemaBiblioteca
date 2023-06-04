package com.example.biblioteca.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String getGmail;
    private int telefono;
    private String direccion;



    public Usuario(String nombre, String apellido, String getGmail, int telefono, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.getGmail = getGmail;
        this.telefono = telefono;
        this.direccion = direccion;

    }

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGetGmail() {
        return getGmail;
    }

    public void setGetGmail(String getGmail) {
        this.getGmail = getGmail;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


}
