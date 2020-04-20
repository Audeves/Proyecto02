package Control;

import Repository.ProductoRepository;
import java.util.List;
import objetosNegocio.Producto;

public class ControlProducto {

    private ProductoRepository productoR;

    public ControlProducto() {
        productoR = new ProductoRepository();
    }

    public void insertarProducto(Producto producto){
        productoR.insertarProducto(producto);
    }
    
    public void actualizarProducto(Producto producto){
        productoR.actualizarProducto(producto);
    }
    
    public boolean eliminarProducto(Integer id){
       return productoR.eliminarProducto(id);
    }
    
    public List<Producto> consultarProductos(String nombre){
        return productoR.consultarProductos(nombre);
    }
    
    public Producto consultarProducto(Integer id){
        return productoR.consultarProducto(id);
    }
    
    
}
