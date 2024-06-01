/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotecaumg.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

/**
 * 
 * 
 * @autor Willy Morales
 */
public class Libro {
    
    // Maquetado de la tabla libros
    private String isbn;
    private String titulo;
    private String autor;
    private Date anioPublicacion;
    private String editorial;
    private int cantidadDisponible;

    // Constructores
    public Libro(String isbn, String titulo, String autor, Date anioPublicacion, String editorial, int cantidadDisponible) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.editorial = editorial;
        this.cantidadDisponible = cantidadDisponible;
    }

    // Getters y setters
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(Date anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
    
    // Guardar en la base de datos
    public void saveToDatabase(Connection conn) throws SQLException {
        String sql = "INSERT INTO libros (isbn, titulo, autor, anioPublicacion, editorial, cantidadDisponible) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.isbn);
            pstmt.setString(2, this.titulo);
            pstmt.setString(3, this.autor);
            pstmt.setDate(4, new java.sql.Date(this.anioPublicacion.getTime()));
            pstmt.setString(5, this.editorial);
            pstmt.setInt(6, this.cantidadDisponible);
            pstmt.executeUpdate();
        }
    }

    // Encontrar por ISBN
    public static Libro findByIsbn(Connection conn, String isbn) throws SQLException {
        String sql = "SELECT * FROM libros WHERE isbn = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, isbn);
            java.sql.ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Libro(rs.getString("isbn"), rs.getString("titulo"), rs.getString("autor"), rs.getDate("anioPublicacion"), rs.getString("editorial"), rs.getInt("cantidadDisponible"));
            }
        }
        return null;
    }

    // Actualizar
    public void update(Connection conn) throws SQLException {
        String sql = "UPDATE libros SET titulo = ?, autor = ?, anioPublicacion = ?, editorial = ?, cantidadDisponible = ? WHERE isbn = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.titulo);
            pstmt.setString(2, this.autor);
            pstmt.setDate(3, new java.sql.Date(this.anioPublicacion.getTime()));
            pstmt.setString(4, this.editorial);
            pstmt.setInt(5, this.cantidadDisponible);
            pstmt.setString(6, this.isbn);
            pstmt.executeUpdate();
        }
    }

    // Eliminar
    public void delete(Connection conn) throws SQLException {
        String sql = "DELETE FROM libros WHERE isbn = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.isbn);
            pstmt.executeUpdate();
        }
    }
}