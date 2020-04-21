/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Luis
 */
public interface BaseRepository <T>{
       EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("PrototipoPuntoDeventaPU");
        EntityManager em = managerFactory.createEntityManager();
   
      public abstract void agregar(T a);
    public abstract void eliminar(T a);
    public abstract void actualizar(T a);
    public abstract T buscarPorId(T a); 
    
    public abstract List<T> mostrarTodas();
    
    
}
