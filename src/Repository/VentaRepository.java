package Repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import objetosNegocio.Venta;

public class VentaRepository {

    public void insertarVenta(Venta venta) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PuntoVentaJPAPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(venta);
        entityManager.getTransaction().commit();
        System.out.println("La venta se ha insertado");
    }

    public void actualizarVenta(Venta venta) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PuntoVentaJPAPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Venta ventaAux = entityManager.find(Venta.class, venta.getId());
        if (ventaAux != null) {
            ventaAux.setFecha(venta.getFecha());
            ventaAux.setCliente(venta.getCliente());
            ventaAux.setDescuento(venta.getDescuento());
            ventaAux.setMontoFinal(venta.getMontoFinal());
            ventaAux.setProductos(venta.getProductos());

            entityManager.persist(ventaAux);

        } else {
            System.out.println("La venta no existe");
        }

        entityManager.getTransaction().commit();
        System.out.println("La venta fue actualizada");
    }

    public void eliminarVenta(Integer id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PuntoVentaJPAPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Venta venta = entityManager.find(Venta.class, id);
        if (venta != null) {
            entityManager.remove(venta);
        } else {
            System.out.println("La venta no fue encontrada");
        }

        entityManager.getTransaction().commit();
        System.out.println("La venta fue eliminada");
    }
    
     public Venta consultarVenta(Integer id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PuntoVentaJPAPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();
        return entityManager.find(Venta.class, id);

    }

    public List<Venta> consultarVentas() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PuntoVentaJPAPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        //CREA EL CONSTRUCTOR DE CONSULTAS.
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        //CONSTRUYE EL OBJETO DE CONSULTAS EN SI.
        criteria.select(criteria.from(Venta.class));
        //CREACION DE LA CONSULTA LISTA PARA EJECUTARSE.
        Query query = entityManager.createQuery(criteria);
        //EJECUCIÓN DEL QUERY Y RETORNO DE RESULTADOS.
        List<Venta> ventas = query.getResultList();

        entityManager.getTransaction().commit();

        return ventas;

    }

    public List<Venta> consultarVentasPorRango(String fechaInicio, String fechaFin, Integer id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PuntoVentaJPAPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Venta> ventas;
        if (id > -1) {
            String jpql = String.format("SELECT * FROM punto_venta.ventas WHERE punto_venta.ventas.fecha >= '%s' and punto_venta.ventas.fecha <= '%s'"
                    + " and punto_venta.ventas.idCliente = %d ;", fechaInicio, fechaFin, id);
            ventas = entityManager.createNativeQuery(jpql, Venta.class).getResultList();
        } else {
            String jpql = String.format("SELECT * FROM punto_venta.ventas WHERE punto_venta.ventas.fecha >= '%s' and punto_venta.ventas.fecha <= '%s';", fechaInicio, fechaFin, id);
            ventas = entityManager.createNativeQuery(jpql, Venta.class).getResultList();
        }
        entityManager.getTransaction().commit();
        return ventas;

    }
}
