/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotecaumg.controlador.conexion;

import java.util.List;

/**
 *
 * @author willymorales
 */
public class Interface {
  


public interface CrudInterface<T> {

     void executeCreate(T object);

    public List<?> executeReadAll();
    public void executeUpdate(T object);
    public void executeDelete(int id);
    public void executeRead(int id);
}
    
}
