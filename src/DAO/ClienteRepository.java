/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.BaseRepository.em;
import ObjetosNegocio.Cliente;
import ObjetosNegocio.Cliente;
import ObjetosNegocio.Proveedor;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class ClienteRepository implements BaseRepository<Cliente> {

    @Override
    public void agregar(Cliente a) {
       try {
            em.getTransaction().begin();

            em.persist(a);

            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Se agrego el cliente");
            System.out.println("Se agrego el cliente");
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null, "no se pudo agregar al cliente");
            System.out.println("No se pudo agregar el cliente");
        }
    }

    @Override
    public void eliminar(Cliente a) {
         try {
            em.getTransaction().begin();
            Cliente clienteEliminado = em.find(Cliente.class, a.getId());
            if (clienteEliminado != null) {
                em.remove(clienteEliminado);
                  JOptionPane.showMessageDialog(null, "Se ha eliminado al cliente");
                System.out.println("Se ha eliminado con exito");
            } else {
                System.out.println("No se pudo eliminar");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("No se pudo eliminar");
              JOptionPane.showMessageDialog(null, "No se pudo eliminar al cliente");
            e.getMessage();
        }
    }

    @Override
    public void actualizar(Cliente a) {
        try {
            em.getTransaction().begin();
            Cliente clienteActualizado = em.find(Cliente.class, a.getId());
            if (clienteActualizado != null) {
                clienteActualizado.setNombre(a.getNombre());
                clienteActualizado.setDireccion(a.getDireccion());
                clienteActualizado.setRfc(a.getRfc());
                clienteActualizado.setTelefono1(a.getTelefono1());
                clienteActualizado.setTelefono2(a.getTelefono2());
                em.merge(clienteActualizado);
                System.out.println("Se ha actualizado con exito");
                  JOptionPane.showMessageDialog(null, "Se actualizo al cliente");
            }else{
                System.out.println("No se pudo actualizar");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("No se pudo actualizar");
              JOptionPane.showMessageDialog(null, "No se actualizo el cliente");
        }
    }

    @Override
    public Cliente buscarPorId(Cliente a) {
          String jpq = "SELECT u FROM Cliente u WHERE u.id = :id";
      TypedQuery<Cliente> query = em.createQuery(jpq, Cliente.class);
       query.setParameter("id", a.getId());
      List<Cliente> clientes =query.getResultList();
        Cliente cliente = clientes.get(0);
        if (clientes.isEmpty()) {
            System.out.println("No se pudo encontrar el cliente");
              return null;
        }else{
            return cliente;
        }
       
    }

    @Override
    public List<Cliente> mostrarTodas() {
       String jpq = "SELECT u FROM Cliente u";
      TypedQuery<Cliente> query = em.createQuery(jpq, Cliente.class);
      List<Cliente> clientes =query.getResultList();
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes");
              return null;
        }else{
             System.out.println("Mostrando todos los clientes");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
        return clientes;
        }
    }
    
     public List<Cliente> buscarPorRFC(String patronRFC) {
        String jpq = "SELECT u FROM Cliente u WHERE u.rfc LIKE :rfc";
        TypedQuery<Cliente> query = em.createQuery(jpq, Cliente.class);
        query.setParameter("rfc", "" + patronRFC + "%");
        List<Cliente> clientes = query.getResultList();
        if (clientes.isEmpty()) {
            System.out.println("No hay categorias");
            return null;
        } else {
            System.out.println("Mostrando todas las categorias");
            for (Cliente cliente : clientes) {
                System.out.println(clientes);
            }
            return clientes;
        }
    }
     public List<Cliente> buscarPorNombre(String patronNombre) {
        String jpq = "SELECT u FROM Cliente u WHERE u.nombre LIKE :nombre";
        TypedQuery<Cliente> query = em.createQuery(jpq, Cliente.class);
        query.setParameter("nombre", "" + patronNombre + "%");
        List<Cliente> clientes = query.getResultList();
        if (clientes.isEmpty()) {
            System.out.println("No hay categorias");
            return null;
        } else {
            System.out.println("Mostrando todas las categorias");
            for (Cliente cliente : clientes) {
                System.out.println(clientes);
            }
            return clientes;
        }
    }
     public List<Cliente> buscarPorDireccion(String patronDireccion) {
        String jpq = "SELECT u FROM Cliente u WHERE u.direccion LIKE :direccion";
        TypedQuery<Cliente> query = em.createQuery(jpq, Cliente.class);
        query.setParameter("direccion", "" + patronDireccion + "%");
        List<Cliente> clientes = query.getResultList();
        if (clientes.isEmpty()) {
            System.out.println("No hay categorias");
            return null;
        } else {
            System.out.println("Mostrando todas las categorias");
            for (Cliente cliente : clientes) {
                System.out.println(clientes);
            }
            return clientes;
        }
    }
    
}
