
package Repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import objetosNegocio.Producto;


public class ProductoRepository {
    
     public void insertarProducto(Producto producto) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PuntoVentaJPAPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        
         entityManager.persist(producto);
         entityManager.getTransaction().commit();
         System.out.println("El producto se ha insertado");
    }
     
     public void actualizarProducto(Producto producto){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PuntoVentaJPAPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Producto productoAux = entityManager.find(Producto.class, producto.getId());
        if (productoAux != null) {
           
            productoAux.setNombre(producto.getNombre());
            productoAux.setPrecioActual(producto.getPrecioActual());
            productoAux.setStock(producto.getStock());
            productoAux.setProvedor(producto.getProvedor());
            productoAux.setCategoria(producto.getCategoria());
            entityManager.persist(productoAux);
            
        } else {
            System.out.println("El producto no existe");
        }

        entityManager.getTransaction().commit();
        System.out.println("El producto fue eliminado");
    }
     
     public boolean eliminarProducto(Integer id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PuntoVentaJPAPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Producto producto = entityManager.find(Producto.class, id);
        if (producto != null) {
            entityManager.remove(producto);
        } else {
            System.out.println("El producto no fue encontrado");
            return false;
        }

        entityManager.getTransaction().commit();
        System.out.println("El producto fue eliminado");
        return true;
    }
     
     public List<Producto> consultarProductos(String nombre) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PuntoVentaJPAPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

         List<Producto> productos;
        if (!nombre.equals("")) {
            String jpql = String.format("SELECT * FROM punto_venta.productos WHERE punto_venta.productos.nombre = '%s';", nombre);
            productos = entityManager.createNativeQuery(jpql, Producto.class).getResultList();
        } else {
            String jpql = "SELECT * FROM punto_venta.productos;";
            productos = entityManager.createNativeQuery(jpql, Producto.class).getResultList();
        }

        entityManager.getTransaction().commit();
        return productos;
        
    }
     
      public Producto consultarProducto(Integer id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PuntoVentaJPAPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();
        return entityManager.find(Producto.class, id);

    }
    
}
