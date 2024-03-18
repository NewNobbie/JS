public class Persona2 {
    private String nombre;
    private int edad;

    //COnstructor
    public Persona2(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    //Get & Set

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}