/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import objetosNegocio.relProductoVentas;

/**
 *
 * @author Luis
 */
public class relProductoVentasRepository {
    
    public void insertarRelacion(relProductoVentas relacion) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PuntoVentaJPAPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(relacion);
        entityManager.getTransaction().commit();
        System.out.println("La relacion se ha insertado");
    }
    
    
    
}
