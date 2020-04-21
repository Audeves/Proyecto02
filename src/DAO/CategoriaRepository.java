/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import ObjetosNegocio.Categoria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class CategoriaRepository implements BaseRepository<Categoria>{
    
        
    
    @Override
    public void agregar(Categoria a) {
        try {
            em.getTransaction().begin();

            em.persist(a);

            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Se agrego la categoria");
            System.out.println("Se agrego la categoria");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo agregar la categoria");
            System.out.println("No se pudo agregar la categoria");
        }
    }

    @Override
    public void eliminar(Categoria a) {
        try {
            em.getTransaction().begin();
            Categoria categoriaEliminada = em.find(Categoria.class, a.getId());
            if (categoriaEliminada != null) {
                em.remove(categoriaEliminada);
                System.out.println("Se ha eliminado con exito");
                JOptionPane.showMessageDialog(null, "Se elimino la categoria");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar la categoria");
                System.out.println("No se pudo eliminar");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar la categoria");
            System.out.println("No se pudo eliminar");
            
        }
    }

    @Override
    public void actualizar(Categoria a) {
        try {
            em.getTransaction().begin();
            Categoria categoriaActualizada  = em.find(Categoria.class, a.getId());
            if (categoriaActualizada != null) {
                categoriaActualizada.setNombre(a.getNombre());
                categoriaActualizada.setDescripcion(a.getDescripcion());
                em.merge(categoriaActualizada);
                System.out.println("Se ha actualizado con exito");
                JOptionPane.showMessageDialog(null, "Se actualizo la categoria");
            }else{
                System.out.println("No se pudo actualizar");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("No se pudo actualizar");
            JOptionPane.showMessageDialog(null, "no se actualizo la categoria");
        }
       
        
        
    }

    @Override
    public Categoria buscarPorId(Categoria a) {
          String jpq = "SELECT u FROM Categoria u WHERE u.id = :id";
      TypedQuery<Categoria> query = em.createQuery(jpq, Categoria.class);
       query.setParameter("id", a.getId());
      List<Categoria> categorias =query.getResultList();
        if (categorias.isEmpty()) {
            System.out.println("No se pudo encontrar la categoria");
            return null;
        } else {
            Categoria categoria = categorias.get(0);
            return categoria;
        }
    }
    

    
    @Override
    public List<Categoria> mostrarTodas() {
      String jpq = "SELECT u FROM Categoria u";
      TypedQuery<Categoria> query = em.createQuery(jpq, Categoria.class);
      List<Categoria> categorias =query.getResultList();
        if (categorias.isEmpty()) {
            System.out.println("No hay categorias");
              return null;
        }else{
             System.out.println("Mostrando todas las categorias");
        for (Categoria categoria : categorias) {
            System.out.println(categoria);
        }
        return categorias;
        }
             
      
    }
    
    public List<Categoria> buscarPorNombre(Categoria a) {
          String jpq = "SELECT u FROM Categoria u WHERE u.nombre LIKE :nombre";
      TypedQuery<Categoria> query = em.createQuery(jpq, Categoria.class);
       query.setParameter("nombre", ""+a.getNombre()+"%");
      List<Categoria> categorias =query.getResultList();
         if (categorias.isEmpty()) {
            System.out.println("No hay categorias");
              return null;
        }else{
             System.out.println("Mostrando todas las categorias");
        for (Categoria categoria : categorias) {
            System.out.println(categoria);
        }
        return categorias;
        }
    }
    
    public List<Categoria> buscarPorDescripcion(String patronDescripcion) {
          String jpq = "SELECT u FROM Categoria u WHERE u.descripcion LIKE :descripcion";
      TypedQuery<Categoria> query = em.createQuery(jpq, Categoria.class);
       query.setParameter("descripcion", ""+patronDescripcion+"%");
      List<Categoria> categorias =query.getResultList();
         if (categorias.isEmpty()) {
            System.out.println("No hay categorias");
              return null;
        }else{
             System.out.println("Mostrando todas las categorias");
        for (Categoria categoria : categorias) {
            System.out.println(categoria);
        }
        return categorias;
        }
    }
    
    
    
}
