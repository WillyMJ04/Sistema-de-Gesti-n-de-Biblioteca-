package com.mycompany.bibliotecaumg.modelo;


public class Cliente {

    //maquetado de la tabla clientes
    private int idCliente;
    private String nombre;
    private String direccion;
    private String telefono;
    private String dpi;
    private int usuarioId;

    //constructor
    public Cliente(int idCliente, String nombre, String direccion, String telefono, String dpi, int usuarioId) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.dpi = dpi;
        this.usuarioId = usuarioId;
    }

    //getters y setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public  void setUsuarioId(int usuarioId){ this.usuarioId = usuarioId;}

}

