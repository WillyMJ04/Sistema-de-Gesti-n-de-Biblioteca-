/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotecaumg.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Willy Morales
 */
public class Rol {
    
    // Maquetado de la tabla roles
    private int rolesId;
    private String nombre;
    
    // Constructores
    public Rol(int rolesId, String nombre) {
        this.rolesId = rolesId;
        this.nombre = nombre;
    }

    // Getters y setters
    public int getRolesId() {
        return rolesId;
    }

    public void setRolesId(int rolesId) {
        this.rolesId = rolesId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // Guardar en la base de datos
    public void saveToDatabase(Connection conn) throws SQLException {
        String sql = "INSERT INTO roles (id, nombre) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.rolesId);
            pstmt.setString(2, this.nombre);
            pstmt.executeUpdate();
        }
    }

    // Encontrar por ID
    public static Rol findById(Connection conn, int id) throws SQLException {
        String sql = "SELECT * FROM roles WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Rol(rs.getInt("id"), rs.getString("nombre"));
            }
        }
        return null;
    }
    
    // Actualizar
    public void update(Connection conn) throws SQLException {
        String sql = "UPDATE roles SET nombre = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.nombre);
            pstmt.setInt(2, this.rolesId);
            pstmt.executeUpdate();
        }
    }

    // Eliminar
    public void delete(Connection conn) throws SQLException {
        String sql = "DELETE FROM roles WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.rolesId);
            pstmt.executeUpdate();
        }
    }
}
