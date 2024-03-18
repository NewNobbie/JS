import java.util.ArrayList;

public class GestionCursos {
    private ArrayList<Curso> cursos;

    //Constructor
    public GestionCursos() {
        cursos = new ArrayList<>();
    }

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

    public Curso buscarCursoCodigo(String codigo) {
        for (Curso curso : cursos) {
            if (curso.getCodigo().equals(codigo)) {
                return curso;
            }
        }
        return null;
    }

    //2
    public void listarEstudiantesCurso(String codigo){
        Curso curso = buscarCursoCodigo(codigo);
        if (curso != null){
            curso.listarEstudiante();
        }else {
            System.out.println("Curso no encontrado.");
        }
    }
}
