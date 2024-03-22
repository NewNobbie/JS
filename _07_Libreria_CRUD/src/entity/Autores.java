package entity;

public class Autores {
    private int id_autores;
    private String name;
    private String nacionalidad;

    public Autores(){

    }

    public Autores(int id_autores, String name, String nacionalidad) {
        this.id_autores = id_autores;
        this.name = name;
        this.nacionalidad = nacionalidad;
    }

    public int getId_autores() {
        return id_autores;
    }

    public String getName() {
        return name;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setId_autores(int id_autores) {
        this.id_autores = id_autores;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "Autores{" +
                "id=" + id_autores +
                ", name='" + name + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                '}';
    }
}
