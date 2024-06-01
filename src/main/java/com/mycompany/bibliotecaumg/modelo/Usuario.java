/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotecaumg.modelo;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * 
 * @autor Willy Morales
 */
public class Usuario {
    
    // Maquetado de la tabla usuarios
    private int idUsuario;
    private String email;
    private String password;
    private String idRol;

    // Constructores
    public Usuario(int idUsuario, String email, String password, String idRol) {
        this.idUsuario = idUsuario;
        this.email = email;
        this.password = password;
        this.idRol = idRol;
    }

    // Getters y setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }
    
    // Método para hashear la contraseña
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (java.security.NoSuchAlgorithmException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // Guardar en la base de datos
    public void saveToDatabase(Connection conn) throws SQLException {
        String sql = "INSERT INTO usuarios (id, email, password, rol_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.idUsuario);
            pstmt.setString(2, this.email);
            pstmt.setString(3, hashPassword(this.password));
            pstmt.setString(4, this.idRol);
            pstmt.executeUpdate();
        }
    }

    // Encontrar por ID
    public static Usuario findById(Connection conn, int id) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            java.sql.ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Usuario(rs.getInt("id"), rs.getString("email"), rs.getString("password"), rs.getString("rol_id"));
            }
        }
        return null;
    }

    // Actualizar
    public void update(Connection conn) throws SQLException {
        String sql = "UPDATE usuarios SET email = ?, password = ?, rol_id = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.email);
            pstmt.setString(2, hashPassword(this.password));
            pstmt.setString(3, this.idRol);
            pstmt.setInt(4, this.idUsuario);
            pstmt.executeUpdate();
        }
    }

    // Eliminar
    public void delete(Connection conn) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.idUsuario);
            pstmt.executeUpdate();
        }
    }
}
