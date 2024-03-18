public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        Producto prod1 = new Producto(1, "Lápiz", 0.50);
        ProductoEspecifico prod2 = new ProductoEspecifico(2, "Cuaderno",
                                                            1.50, "Papeleria", "Ecológico");

        inventario.agregarProducto(prod1);
        inventario.agregarProducto(prod2);

        inventario.listarProductos();

        inventario.eliminarProducto(1);

        System.out.println("\nDespués de eliminar:");
        inventario.listarProductos();
    }
}