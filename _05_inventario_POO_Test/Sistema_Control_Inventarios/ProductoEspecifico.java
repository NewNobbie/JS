public class ProductoEspecifico extends Producto{
    private String categoria;
    private String marca;

    //Constructor
    public ProductoEspecifico(int id, String nombre, double precio, String categoria, String marca){
        super(id, nombre, precio);
        this.categoria = categoria;
        this.marca = marca;
    }

    //Get & Set
    public String getCategoria() {
        return categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


}
