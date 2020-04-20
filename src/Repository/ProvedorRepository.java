
package Repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import objetosNegocio.Provedor;

public class ProvedorRepository {

    public void insertarProvedor(Provedor provedor) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PuntoVentaJPAPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(provedor);
        entityManager.getTransaction().commit();
        System.out.println("El provedor se ha insertado");
    }

    public void actualizarProvedor(Provedor provedor) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PuntoVentaJPAPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Provedor provedorAux = entityManager.find(Provedor.class, provedor.getId());
        if (provedorAux != null) {
            provedorAux.setRfc(provedor.getRfc());
            provedorAux.setNombre(provedor.getNombre());
            provedorAux.setDireccion(provedor.getDireccion());
            provedorAux.setTelefono(provedor.getTelefono());
            provedorAux.setPaginaWeb(provedor.getPaginaWeb());

            entityManager.persist(provedorAux);

        } else {
            System.out.println("El provedor no existe");
        }

        entityManager.getTransaction().commit();
        System.out.println("El provedor fue actualizado");
    }
    
     public boolean eliminarProvedor(Integer id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PuntoVentaJPAPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Provedor provedor = entityManager.find(Provedor.class, id);
        if (provedor != null) {
            entityManager.remove(provedor);
        } else {
            System.out.println("El provedor no fue encontrado");
            return false;
        }

        entityManager.getTransaction().commit();
        System.out.println("El provedor fue eliminado");
        return true;
    }
     
      public List<Provedor> consultarProvedores(String nombre) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PuntoVentaJPAPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

         List<Provedor> provedores;
        if (!nombre.equals("")) {
            String jpql = String.format("SELECT * FROM punto_venta.provedores WHERE punto_venta.provedores.nombre = '%s';", nombre);
            provedores = entityManager.createNativeQuery(jpql, Provedor.class).getResultList();
        } else {
            String jpql = "SELECT * FROM punto_venta.provedores;";
            provedores = entityManager.createNativeQuery(jpql, Provedor.class).getResultList();
        }
        entityManager.getTransaction().commit();
        return provedores;
    }

    public Provedor consultarProvedor(Integer id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PuntoVentaJPAPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();
        return entityManager.find(Provedor.class, id);

    }

}
