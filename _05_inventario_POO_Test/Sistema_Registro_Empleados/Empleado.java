public class Empleado extends Persona2 {
    private int idEmpleado;
    private double salario;

    //Constructor
    public Empleado(String nombre, int edad, int idEmpleado, double salario){
        super(nombre, edad);
        this.idEmpleado = idEmpleado;
        this.salario = salario;
    }

    //Get & Set

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public double getSalario() {
        return salario;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}