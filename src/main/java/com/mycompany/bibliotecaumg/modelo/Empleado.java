package com.mycompany.bibliotecaumg.modelo;


/**
 *
 * @author Willy Morales
 */

public class Empleado {

    //maquetado de la tabla empleados
    private int empleadoId;
    private String nombre;
    private int usuarioId;


    //constructores
    public Empleado(int empleadoId, String nombre, int usuarioId) {
        this.empleadoId = empleadoId;
        this.nombre = nombre;
        this.usuarioId = usuarioId;
    }

    //getter y setter
    public int getempleadoId() {
        return empleadoId;
    }

    public void setempleadoIds(int empleadoId) {
        this.empleadoId = empleadoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
      public String getusuarioId() {
        return nombre;
    }
      
    public void setusuarioId(int usuarioId){
        this.usuarioId = usuarioId;
    }
    
    
}