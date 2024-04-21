/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biblioteca;

/**
 *
 * @author Willy Morales
 */
public class Libros {


    //maquetado de la tabla libros
    private string isbn;
    private String titulo;
    private String autor;
    private date anioPublicacion;
    private String editorial;
    private int cantidadDisponible;


    //constructores
    public Libros(string isbn, String titulo, String autor, date anioPublicacion, String editorial, int cantidadDisponible) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.editorial = editorial;
        this.cantidadDisponible = cantidadDisponible;
    }

    // getters y setters
    public string getIsbn() {
        return isbn;
    }

    public void setIsbn(string isbn) {
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

    public date getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(date anioPublicacion) {
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
}
