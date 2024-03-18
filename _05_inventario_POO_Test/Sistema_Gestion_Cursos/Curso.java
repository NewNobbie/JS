import java.util.ArrayList;

public class Curso {
    private String codigo;
    private String nombre;
    private ArrayList<Estudiante> listaEstudiantes;

    //Constructor
    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.listaEstudiantes = new ArrayList<>();
    }

    //Métodos
    public void inscribirEstudiante(Estudiante estudiante){
        listaEstudiantes.add(estudiante);
    }
    public boolean desincribirEstudiante(int idEstudiante){
        return listaEstudiantes.removeIf(e -> e.getId() == idEstudiante);
    }
    public void listarEstudiante(){
        System.out.println("Estudiante inscritos en el curso "+ nombre + ":");
        for (Estudiante e : listaEstudiantes) {
            System.out.println("ID: " + e.getId() + ", Nombre: " + e.getNombre());
        }
    }

    //Get & Set


    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
