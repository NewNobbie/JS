import java.util.Scanner;

public class Main3 {
    public static void main3(String[] args){

        //Instancias
        Scanner objScan = new Scanner(System.in);
        GestionCursos gestionCursos = new GestionCursos();

        Curso curso1 = new Curso("CS101", "Introduccion a la Programacion");
        Curso curso2 = new Curso("CS102","Estructuras de Datos");

        Estudiante estudiante1 = new Estudiante(1, "Juan Pérez", "jprirri@gmail.com");
        Estudiante estudiante2 = new Estudiante(2, "Maria López", "MarialaMasflipa@gmail.com");

        curso1.inscribirEstudiante(estudiante1);
        curso2.inscribirEstudiante(estudiante2);

        gestionCursos.agregarCurso(curso1);
        gestionCursos.agregarCurso(curso2);

        gestionCursos.listarEstudiantesCurso("CS101");
        gestionCursos.listarEstudiantesCurso("CS102");


        //Proximamente, solo en Cines
        /*byte opcion = 0;
        do {
            System.out.println("""
                    MENU DE OPCIONES
                    1. Agregar Cursos
                    2. Inscribir Estudiantes a Cursos
                    3. Listar Estudiantes inscritos en un Curso
                    4. Salir""");
            opcion = objScan.nextByte();
            switch (opcion){
                case 1:

            }
        }while ()*/
    }
}
