package entity;

import entity.Autores;

public class Libros extends Autores {

    private int id;
    private String titulo;
    private int año_Publicación;
    private double precio;

    public Libros(int id_autores, String name, String nacionalidad, int id, String titulo, int año_Publicación, double precio) {
        super(id_autores, name, nacionalidad);
        this.id = id;
        this.titulo = titulo;
        this.año_Publicación = año_Publicación;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAño_Publicación() {
        return año_Publicación;
    }

    public double getPrecio() {
        return precio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAño_Publicación(int año_Publicación) {
        this.año_Publicación = año_Publicación;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Libros{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", año_Publicación=" + año_Publicación +
                ", precio=" + precio +
                '}';
    }
}
