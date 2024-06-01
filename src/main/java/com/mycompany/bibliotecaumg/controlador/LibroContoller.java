package com.mycompany.bibliotecaumg.controlador;

import com.mycompany.bibliotecaumg.inter.CRUDController;
import com.mycompany.bibliotecaumg.modelo.Libro;

import java.util.List;

public class LibroContoller implements CRUDController<Libro> {

    @Override
    public String insert(Libro data) {
        return "";
    }

    @Override
    public String actualizar(Libro data) {
        return "";
    }

    @Override
    public String eliminar(Libro data) {
        return "";
    }

    @Override
    public List<Libro> listarTodos() {
        return List.of();
    }
}
