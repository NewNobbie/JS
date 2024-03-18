public class Main2 {
    public static void main(String[] args){
        GestionEmpleados gestionEmpleados = new GestionEmpleados();

        Empleado empleado1 = new EmpleadoPermanente("Pepito Gonzales", 30, 1, 3000, 5);
        Empleado empleado2 = new EmpleadoTemporal("Maria Lopez", 25, 2, 2500, "31/12/2024");

        gestionEmpleados.agregarEmpleado(empleado1);
        gestionEmpleados.agregarEmpleado(empleado2);

        gestionEmpleados.mostrarEmpleados();
        gestionEmpleados.eliminarEmpleado(1);

        System.out.println("\nDespués de eliminar:");
        gestionEmpleados.mostrarEmpleados();


    }
}