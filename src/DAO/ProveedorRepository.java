/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ObjetosNegocio.Categoria;
import ObjetosNegocio.Proveedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Luis
 */
public class ProveedorRepository implements BaseRepository<Proveedor> {

    @Override
    public void agregar(Proveedor a) {
        try {
            em.getTransaction().begin();

            em.persist(a);

            em.getTransaction().commit();
            System.out.println("Se agrego al proveedor");
        } catch (Exception e) {
            System.out.println("No se pudo agregar al proveedor");
        }
    }

    @Override
    public void eliminar(Proveedor a) {
        try {
            em.getTransaction().begin();
            Proveedor proveedorEliminado = em.find(Proveedor.class, a.getId());
            if (proveedorEliminado != null) {
                em.remove(proveedorEliminado);
                System.out.println("Se ha eliminado con exito");
            } else {
                System.out.println("No se pudo eliminar");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("No se pudo eliminar");
            e.getMessage();
        }
    }

    @Override
    public void actualizar(Proveedor a) {
        try {
            em.getTransaction().begin();
            Proveedor proveedorActualizado = em.find(Proveedor.class, a.getId());
            if (proveedorActualizado != null) {
                proveedorActualizado.setNombre(a.getNombre());
                proveedorActualizado.setDireccion(a.getDireccion());
                proveedorActualizado.setPaginaWeb(a.getPaginaWeb());
                proveedorActualizado.setRfc(a.getRfc());
                proveedorActualizado.setTelefono(a.getTelefono());
                em.merge(proveedorActualizado);
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
    public Proveedor buscarPorId(Proveedor a) {
        String jpq = "SELECT u FROM Proveedor u WHERE u.id = :id";
        TypedQuery<Proveedor> query = em.createQuery(jpq, Proveedor.class);
        query.setParameter("id", a.getId());
        List<Proveedor> proveedores = query.getResultList();
        if (proveedores.isEmpty()) {
            System.out.println("No se pudo encontrar al proveedor");
            return null;
        } else {
            Proveedor proveedor = proveedores.get(0);
            return proveedor;
        }
    }

    @Override
    public List<Proveedor> mostrarTodas() {
        String jpq = "SELECT u FROM Proveedor u";
        TypedQuery<Proveedor> query = em.createQuery(jpq, Proveedor.class);
        List<Proveedor> proveedores = query.getResultList();
        if (proveedores.isEmpty()) {
            System.out.println("No hay proveedores");
        } else {
            System.out.println("Mostrando todas los proveedores");
            for (Proveedor proveedor : proveedores) {
                System.out.println(proveedor);
            }
            return proveedores;
        }

        return null;
    }

    public Proveedor buscarPorNombre(Proveedor a) {
        String jpq = "SELECT u FROM Proveedor u WHERE u.nombre = :nombre";
        TypedQuery<Proveedor> query = em.createQuery(jpq, Proveedor.class);
        query.setParameter("nombre", a.getNombre());
        List<Proveedor> proveedores = query.getResultList();
        if (proveedores.isEmpty()) {
            System.out.println("No se pudo encontrar al proveedor");
            return null;
        } else {
            Proveedor proveedor = proveedores.get(0);
            return proveedor;
        }
    }

    public List<Proveedor> buscarPorRFC(String patronRFC) {
        String jpq = "SELECT u FROM Proveedor u WHERE u.rfc LIKE :rfc";
        TypedQuery<Proveedor> query = em.createQuery(jpq, Proveedor.class);
        query.setParameter("rfc", "" + patronRFC + "%");
        List<Proveedor> proveedores = query.getResultList();
        if (proveedores.isEmpty()) {
            System.out.println("No hay categorias");
            return null;
        } else {
            System.out.println("Mostrando todas las categorias");
            for (Proveedor proveedor : proveedores) {
                System.out.println(proveedores);
            }
            return proveedores;
        }
    }

    /**
     *
     * @param patronNombre
     * @return
     */
    public List<Proveedor> buscarPorNombre(String patronNombre) {
        String jpq = "SELECT u FROM Proveedor u WHERE u.nombre LIKE :nombre";
        TypedQuery<Proveedor> query = em.createQuery(jpq, Proveedor.class);
        query.setParameter("nombre", "" + patronNombre + "%");
        List<Proveedor> proveedores = query.getResultList();
        if (proveedores.isEmpty()) {
            System.out.println("No hay proveedores");
            return null;
        } else {
            System.out.println("Mostrando todos los proveedores");
            for (Proveedor proveedor : proveedores) {
                System.out.println(proveedores);
            }
            return proveedores;
        }
    }

    public List<Proveedor> buscarPorDireccion(String patronDireccion) {
        String jpq = "SELECT u FROM Proveedor u WHERE u.direccion LIKE :direccion";
        TypedQuery<Proveedor> query = em.createQuery(jpq, Proveedor.class);
        query.setParameter("direccion", "" + patronDireccion + "%");
        List<Proveedor> proveedores = query.getResultList();
        if (proveedores.isEmpty()) {
            System.out.println("No hay proveedores");
            return null;
        } else {
            System.out.println("Mostrando todos los proveedores");
            for (Proveedor proveedor : proveedores) {
                System.out.println(proveedores);
            }
            return proveedores;
        }
    }
    
    public List<Proveedor> buscarPorPagina(String patronPagina) {
          String jpq = "SELECT u FROM Proveedor u WHERE u.paginaWeb LIKE :paginaweb";
      TypedQuery<Proveedor> query = em.createQuery(jpq, Proveedor.class);
       query.setParameter("paginaweb", ""+patronPagina+"%");
      List<Proveedor> proveedores =query.getResultList();
         if (proveedores.isEmpty()) {
            System.out.println("No hay proveedores");
              return null;
        }else{
             System.out.println("Mostrando todos los proveedores");
        for (Proveedor proveedor : proveedores) {
            System.out.println(proveedores);
        }
        return proveedores;
        }
    }
    
    

}
