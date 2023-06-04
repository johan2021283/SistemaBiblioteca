package com.example.biblioteca.Entity;

public class PrestamoResponse {
    private String mensaje;
    private Prestamo prestamo;

    public PrestamoResponse(String mensaje, Prestamo prestamo) {
        this.mensaje = mensaje;
        this.prestamo = prestamo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }
}
