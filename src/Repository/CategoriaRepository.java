/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import objetosNegocio.Categoria;

/**
 *
 * @author Luis
 */
public class CategoriaRepository {

    public void insertarCategoria(Categoria categoria) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PuntoVentaJPAPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        
         entityManager.persist(categoria);
         entityManager.getTransaction().commit();
         System.out.println("La categoria se ha insertado");
    }
    
    public void actualizarCategoria(Categoria categoria){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PuntoVentaJPAPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Categoria categoriaAux = entityManager.find(Categoria.class, categoria.getId());
        if (categoriaAux != null) {
            categoria.setNombre(categoria.getNombre());
            categoria.setDescripcion(categoria.getDescripcion());
            entityManager.merge(categoria);
            
        } else {
            System.out.println("La categoria no existe");
        }

        entityManager.getTransaction().commit();
        System.out.println("La categoria fue actualizada");
    }

    public boolean eliminarCategoria(Integer id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PuntoVentaJPAPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Categoria categoria = entityManager.find(Categoria.class, id);
        if (categoria != null) {
            entityManager.remove(categoria);
        } else {
            System.out.println("La categoria no fue encontrada");
            return false;
        }

        entityManager.getTransaction().commit();
        System.out.println("La categoria fue eliminada");
        return true;
    }


    public Categoria consultarCategoria(Integer id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PuntoVentaJPAPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();
        return entityManager.find(Categoria.class, id);

    }
    
    public List<Categoria> consultarCategorias(String nombre) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PuntoVentaJPAPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Categoria> categorias;
        if (!nombre.equals("")) {
            String jpql = String.format("SELECT * FROM punto_venta.categorias WHERE punto_venta.categorias.nombre = '%s';", nombre);
            categorias = entityManager.createNativeQuery(jpql, Categoria.class).getResultList();
        } else {
            String jpql = "SELECT * FROM punto_venta.categorias;";
            categorias = entityManager.createNativeQuery(jpql, Categoria.class).getResultList();
        }
        entityManager.getTransaction().commit();
        return categorias;

    }
}
