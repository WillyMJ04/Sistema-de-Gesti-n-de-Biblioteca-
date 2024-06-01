/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotecaumg.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Willy Morales
 */
public class Prestamo {
    
    //maquetado de la tabla prestamos
    private int idPrestamo;
    private int clienteId;
    private String isbn;
    private Date fechaPrestamo;
    private Date fechaDevolucionEsperada;
    private Date fechaDevolucion;
    private float multa;

    //contructores
    public Prestamo(int idPrestamo, int clienteId, String isbn, Date fechaPrestamo, Date fechaDevolucionEsperada, Date fechaDevolucionReal, float multa) {
        this.idPrestamo = idPrestamo;
        this.clienteId = clienteId;
        this.isbn = isbn;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucionEsperada = fechaDevolucionEsperada;
        this.fechaDevolucion = fechaDevolucion;
        this.multa = multa;
    }

    //getter y setter
    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getFechaPrestam() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucionEsperada() {
        return fechaDevolucionEsperada;
    }

    public void setFechaDevolucionEsperada(Date fechaDevolucionEsperada) {
        this.fechaDevolucionEsperada = fechaDevolucionEsperada;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public float getMulta() {
        return multa;
    }

    public void setMulta(float multa) {
        this.multa = multa;
    }
      
    
    
    public void saveToDatabase(Connection conn) throws SQLException {
        String sql = "INSERT INTO prestamos (id, cliente_id, isbn, fecha_prestamo, fecha_devolucion_estimada, fecha_devolucion, multa) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.idPrestamo);
            pstmt.setInt(2, this.clienteId);
            pstmt.setString(3, this.isbn);
            pstmt.setDate(4, new java.sql.Date(this.fechaPrestamo.getTime()));
            pstmt.setDate(5, new java.sql.Date(this.fechaDevolucionEsperada.getTime()));
            pstmt.setDate(6, this.fechaDevolucion != null ? new java.sql.Date(this.fechaDevolucion.getTime()) : null);
            pstmt.setFloat(7, this.multa);
            pstmt.executeUpdate();
        }
    }

    public static Prestamo findById(Connection conn, int id) throws SQLException {
        String sql = "SELECT * FROM prestamos WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            java.sql.ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Date fechaDevolucion = rs.getDate("fecha_devolucion");
                return new Prestamo(rs.getInt("id"), rs.getInt("cliente_id"), rs.getString("isbn"), rs.getDate("fecha_prestamo"), rs.getDate("fecha_devolucion_estimada"), fechaDevolucion, rs.getFloat("multa"));
            }
        }
        return null;
    }

    public void update(Connection conn) throws SQLException {
        String sql = "UPDATE prestamos SET cliente_id = ?, isbn = ?, fecha_prestamo = ?, fecha_devolucion_estimada = ?, fecha_devolucion = ?, multa = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.clienteId);
            pstmt.setString(2, this.isbn);
            pstmt.setDate(3, new java.sql.Date(this.fechaPrestamo.getTime()));
            pstmt.setDate(4, new java.sql.Date(this.fechaDevolucionEsperada.getTime()));
            pstmt.setDate(5, this.fechaDevolucion != null ? new java.sql.Date(this.fechaDevolucion.getTime()) : null);
            pstmt.setFloat(6, this.multa);
            pstmt.setInt(7, this.idPrestamo);
            pstmt.executeUpdate();
        }
    }

    public void delete(Connection conn) throws SQLException {
        String sql = "DELETE FROM prestamos WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.idPrestamo);
            pstmt.executeUpdate();
        }
    }
    
    
    
    
    
}
