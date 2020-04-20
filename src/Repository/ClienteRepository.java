
package Repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import objetosNegocio.Cliente;


public class ClienteRepository {
 
     public void insertarCliente(Cliente cliente) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PuntoVentaJPAPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        
         entityManager.persist(cliente);
         entityManager.getTransaction().commit();
         System.out.println("El cliente se ha insertado");
    }
     
     public void actualizarCliente(Cliente cliente){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PuntoVentaJPAPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Cliente clienteAux = entityManager.find(Cliente.class, cliente.getId());
        if (clienteAux != null) {
            clienteAux.setRfc(cliente.getRfc());
            clienteAux.setNombre(cliente.getNombre());
            clienteAux.setDireccion(cliente.getDireccion());
            clienteAux.setTelefono1(cliente.getTelefono1());
            clienteAux.setTelefono2(cliente.getTelefono2());
            clienteAux.setVentas(cliente.getVentas());
            entityManager.merge(clienteAux);
            
        } else {
            System.out.println("El cliente no existe");
        }

        entityManager.getTransaction().commit();
        System.out.println("El cliente fue actualizado");
    }
     
     public boolean eliminarCliente(Integer id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PuntoVentaJPAPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Cliente cliente = entityManager.find(Cliente.class, id);
        if (cliente != null) {
            entityManager.remove(cliente);
        } else {
            System.out.println("El cliente no fue encontrado");
            return false;
        }

        entityManager.getTransaction().commit();
        System.out.println("El cliente fue eliminado");
        return true;
    }

    public List<Cliente> consultarClientes(String nombre) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PuntoVentaJPAPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Cliente> clientes;
        if (!nombre.equals("")) {
            String jpql = String.format("SELECT * FROM punto_venta.clientes WHERE punto_venta.clientes.nombre = '%s';", nombre);
            clientes = entityManager.createNativeQuery(jpql, Cliente.class).getResultList();
        } else {
            String jpql = "SELECT * FROM punto_venta.clientes;";
            clientes = entityManager.createNativeQuery(jpql, Cliente.class).getResultList();
        }
        entityManager.getTransaction().commit();
        return clientes;

    }

    public Cliente consultarCliente(Integer id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PuntoVentaJPAPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();
        return entityManager.find(Cliente.class, id);

    }

}
