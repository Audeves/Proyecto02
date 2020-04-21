/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.BaseRepository.em;
import ObjetosNegocio.RelProductosVentas;
import ObjetosNegocio.Venta;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Luis
 */
public class RPVRepository implements BaseRepository<RelProductosVentas> {

    @Override
    public void agregar(RelProductosVentas a) {
         try {
            em.getTransaction().begin();

            em.persist(a);

            em.getTransaction().commit();
            System.out.println("Se agrego la rpv");
        } catch (Exception e) {
            System.out.println("No se pudo agregar la rpv");
        }
    }

    @Override
    public void eliminar(RelProductosVentas a) {
        try {
            em.getTransaction().begin();
            RelProductosVentas rpvEliminada = em.find(RelProductosVentas.class, a.getId());
            if (rpvEliminada != null) {
                em.remove(rpvEliminada);
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
    public void actualizar(RelProductosVentas a) {
        try {
            em.getTransaction().begin();
            RelProductosVentas rpvActualizado = em.find(RelProductosVentas.class, a.getId());
            if (rpvActualizado != null) {
                rpvActualizado.setCantidad(a.getCantidad());
                rpvActualizado.setMontoTotal(a.getMontoTotal());
                rpvActualizado.setPrecio(a.getPrecio());
                rpvActualizado.setProducto(a.getProducto());
                rpvActualizado.setVenta(a.getVenta());
                em.merge(rpvActualizado);
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
    public RelProductosVentas buscarPorId(RelProductosVentas a) {
       String jpq = "SELECT u FROM RelProductosVentas u WHERE u.id = :id";
        TypedQuery<RelProductosVentas> query = em.createQuery(jpq, RelProductosVentas.class);
        query.setParameter("id", a.getId());
        List<RelProductosVentas> rpvs = query.getResultList();
        RelProductosVentas rpv = rpvs.get(0);
        if (rpvs.isEmpty()) {
            System.out.println("No se pudo encontrar la rpv");
             return null;
        }else{
            return rpv;
        }
       
    }

    @Override
    public List<RelProductosVentas> mostrarTodas() {
         String jpq = "SELECT u FROM RelProductosVentas u";
        TypedQuery<RelProductosVentas> query = em.createQuery(jpq, RelProductosVentas.class);
        List<RelProductosVentas> rpvs = query.getResultList();
        if (rpvs.isEmpty()) {
            System.out.println("No hay rpvs");
            return null;
        } else {
            System.out.println("Mostrando todas las rpvs");
            for (RelProductosVentas rpv : rpvs) {
                System.out.println(rpv);
            }
            return rpvs;
        }

        
    }
    
    public List<RelProductosVentas> mostrarTodasConIdVenta(Venta venta){
          String jpq = "SELECT u FROM RelProductosVentas u where u.venta = :venta";
        TypedQuery<RelProductosVentas> query = em.createQuery(jpq, RelProductosVentas.class);
        query.setParameter("venta", venta);
        List<RelProductosVentas> rpvs = query.getResultList();
        if (rpvs.isEmpty()) {
            System.out.println("No hay rpvs");
            return null;
        } else {
            System.out.println("Mostrando todas las rpvs");
            for (RelProductosVentas rpv : rpvs) {
                System.out.println(rpv);
            }
            return rpvs;
        }
    }
    
}
