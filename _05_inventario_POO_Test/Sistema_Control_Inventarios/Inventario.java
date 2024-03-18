import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> productos;

    //Constructor
    public Inventario() {
        this.productos = new ArrayList<>();
    }

    //Métodos
    public void agregarProducto(Producto producto){
        productos.add(producto);
    }
    public boolean eliminarProducto(int id){
        return productos.removeIf(p -> p.getId() == id);
    }

    public void listarProductos(){
        for (Producto p : productos) {
            System.out.println("ID: " + p.getId() +
                                ", Nombre: " + p.getNombre() +
                                ", Precio: " + p.getPrecio());
        }
    }

}
