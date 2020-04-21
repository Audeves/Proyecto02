/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.BaseRepository.em;

import ObjetosNegocio.Producto;
import ObjetosNegocio.Proveedor;
import java.util.List;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class ProductoRepository implements BaseRepository<Producto> {

    @Override
    public void agregar(Producto a) {
        try {
            em.getTransaction().begin();

            em.persist(a);

            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Se agrego el producto");
            System.out.println("Se agrego el producto");
        } catch (Exception e) {
            System.out.println("No se pudo agregar el producto");
            JOptionPane.showMessageDialog(null, "No se pudo agregar el producto");
        }
    }

    @Override
    public void eliminar(Producto a) {
        try {
            em.getTransaction().begin();
            Producto productoEliminada = em.find(Producto.class, a.getId());
            if (productoEliminada != null) {
                em.remove(productoEliminada);
                System.out.println("Se ha eliminado con exito");
                JOptionPane.showMessageDialog(null, "Se ha eliminado el producto");
            } else {
                System.out.println("No se pudo eliminar");
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el producto");
            }
            em.getTransaction().commit();
        } catch (RollbackException e) {
            System.out.println("No se pudo eliminar");
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Producto a) {
        try {
            em.getTransaction().begin();
            Producto productoActualizado = em.find(Producto.class, a.getId());
            if (productoActualizado != null) {
                productoActualizado.setNombre(a.getNombre());
                productoActualizado.setCategoria(a.getCategoria());
                productoActualizado.setPrecioActual(a.getPrecioActual());
                productoActualizado.setProveedor(a.getProveedor());
                productoActualizado.setStock(a.getStock());
                em.merge(productoActualizado);
                System.out.println("Se ha actualizado con exito");
            } else {
                System.out.println("No se pudo actualizar");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("No se pudo actualizar");
        }

    }

    @Override
    public Producto buscarPorId(Producto a) {
        String jpq = "SELECT u FROM Producto u WHERE u.id = :id";
        TypedQuery<Producto> query = em.createQuery(jpq, Producto.class);
        query.setParameter("id", a.getId());
        List<Producto> productos = query.getResultList();
        Producto producto = productos.get(0);
        if (productos.isEmpty()) {
            System.out.println("No se pudo encontrar el producto");
            return null;
        } else {
            return producto;
        }
    }

    public Producto buscarPorPrecio(Producto a) {
        String jpq = "SELECT u FROM Producto u WHERE u.precioActual = :precioactual";
        TypedQuery<Producto> query = em.createQuery(jpq, Producto.class);
        query.setParameter("precioactual", a.getPrecioActual());
        List<Producto> productos = query.getResultList();
        Producto producto = productos.get(0);
        if (productos.isEmpty()) {
            System.out.println("No se pudo encontrar el producto");
            return null;
        } else {
            return producto;
        }
    }

    public Producto buscarPorStock(Producto a) {
        String jpq = "SELECT u FROM Producto u WHERE u.stock = :stock";
        TypedQuery<Producto> query = em.createQuery(jpq, Producto.class);
        query.setParameter("stock", a.getStock());
        List<Producto> productos = query.getResultList();
        Producto producto = productos.get(0);
        if (productos.isEmpty()) {
            System.out.println("No se pudo encontrar el producto");
            return null;
        } else {
            return producto;
        }
    }

    public Producto buscarPorIDProveedor(int idProveedor) {
        String jpq = "SELECT u FROM Producto u WHERE u.idproveedor = :id";
        TypedQuery<Producto> query = em.createQuery(jpq, Producto.class);
        query.setParameter("id", idProveedor);
        List<Producto> productos = query.getResultList();
        Producto producto = productos.get(0);
        if (productos.isEmpty()) {
            System.out.println("No se pudo encontrar el producto");
            return null;
        } else {
            return producto;
        }
    }


    @Override
    public List<Producto> mostrarTodas() {
        String jpq = "SELECT u FROM Producto u";
        TypedQuery<Producto> query = em.createQuery(jpq, Producto.class);
        List<Producto> productos = query.getResultList();
        if (productos.isEmpty()) {
            System.out.println("No hay productos");
            return null;
        } else {
            System.out.println("Mostrando todos los productos");
            for (Producto producto : productos) {
                System.out.println(producto);
            }
            return productos;
        }

    }

    public Producto buscarPorNombre(Producto a) {
        String jpq = "SELECT u FROM Producto u WHERE u.nombre = :nombre";
        TypedQuery<Producto> query = em.createQuery(jpq, Producto.class);
        query.setParameter("nombre", a.getNombre());
        List<Producto> productos = query.getResultList();
        Producto producto = productos.get(0);
        if (productos.isEmpty()) {
            System.out.println("No se pudo encontrar el producto");
            return null;
        } else {
            return producto;
        }
    }

    /**
     *
     * @param patronNombre
     * @return
     */
    public List<Producto> buscarPorNombre(String patronNombre) {
        String jpq = "SELECT u FROM Producto u WHERE u.nombre LIKE :nombre";
        TypedQuery<Producto> query = em.createQuery(jpq, Producto.class);
        query.setParameter("nombre", "" + patronNombre + "%");
        List<Producto> productos = query.getResultList();
        if (productos.isEmpty()) {
            System.out.println("No hay proveedores");
            return null;
        } else {
            System.out.println("Mostrando todos los proveedores");
            for (Producto producto : productos) {
                System.out.println(productos);
            }
            return productos;
        }
    }

    /**
     *
     * @param patronNombre
     * @return
     */
//    public List<Producto> buscarPorProveedor(String patronNombre) {
//        String jpq = "SELECT u FROM Producto u WHERE u.nombre LIKE :nombre "
//                + "INNER JOIN";
//        TypedQuery<Producto> query = em.createQuery(jpq, Producto.class);
//        query.setParameter("nombre", "" + patronNombre + "%");
//        List<Producto> productos = query.getResultList();
//        if (productos.isEmpty()) {
//            System.out.println("No hay proveedores");
//            return null;
//        } else {
//            System.out.println("Mostrando todos los proveedores");
//            for (Producto producto : productos) {
//                System.out.println(productos);
//            }
//            return productos;
//        }
//    }
}
