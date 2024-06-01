package com.mycompany.bibliotecaumg.inter;

import java.util.List;

public interface  CRUDController <T>{
    public String insert(T data);
    public String actualizar(T data);
    public String eliminar(T data);
    public List <T> listarTodos();
}
