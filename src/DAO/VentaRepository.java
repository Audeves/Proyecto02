/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.BaseRepository.em;
import ObjetosNegocio.Cliente;
import ObjetosNegocio.Venta;
import java.util.Calendar;
import java.util.List;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 *
 * @author Luis
 */
public class VentaRepository implements BaseRepository<Venta> {

    @Override
    public void agregar(Venta a) {
        try {
            em.getTransaction().begin();

            em.persist(a);

            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Se agrego la venta", "Aviso", INFORMATION_MESSAGE);
            System.out.println("Se agrego la venta");
        } catch (Exception e) {
               JOptionPane.showMessageDialog(null, "No se pudo agregar la venta", "Aviso", INFORMATION_MESSAGE);
            System.out.println("No se pudo agregar la venta");
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Venta a) {
        try {
            em.getTransaction().begin();
            Venta ventaEliminada = em.find(Venta.class, a.getId());
            if (ventaEliminada != null) {
                em.remove(ventaEliminada);
                System.out.println("Se ha eliminado con exito");
            } else {
                System.out.println("No se pudo eliminar");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("No se pudo eliminar");
        }
    }

    @Override
    public void actualizar(Venta a) {
        try {
            em.getTransaction().begin();
            Venta ventaActualizado = em.find(Venta.class, a.getId());
            if (ventaActualizado != null) {
                ventaActualizado.setCliente(a.getCliente());
                ventaActualizado.setDescuento(a.getDescuento());
                ventaActualizado.setFecha(a.getFecha());
                ventaActualizado.setMontoFinal(a.getMontoFinal());
                em.merge(ventaActualizado);
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
    public Venta buscarPorId(Venta a) {
        String jpq = "SELECT u FROM Venta u WHERE u.id = :id";
        TypedQuery<Venta> query = em.createQuery(jpq, Venta.class);
        query.setParameter("id", a.getId());
        List<Venta> ventas = query.getResultList();
        Venta venta = ventas.get(0);
        if (ventas.isEmpty()) {
            System.out.println("No se pudo encontrar la venta");
            return null;
        } else {
            return venta;
        }

    }

    @Override
    public List<Venta> mostrarTodas() {
        String jpq = "SELECT u FROM Venta u";
        TypedQuery<Venta> query = em.createQuery(jpq, Venta.class);
        List<Venta> ventas = query.getResultList();
        if (ventas.isEmpty()) {
            System.out.println("No hay ventas");
            return null;
        } else {
            System.out.println("Mostrando todas las ventas");
            for (Venta venta : ventas) {
                System.out.println(venta);
            }
            return ventas;
        }

    }

    public List<Venta> mostrarEntre(Calendar startDate, Calendar endDate) {
        String jpq = "SELECT u FROM Venta u WHERE u.fecha BETWEEN :startDate AND :endDate";
        TypedQuery<Venta> query = em.createQuery(jpq, Venta.class);
        query.setParameter("startDate", startDate, TemporalType.DATE);
        query.setParameter("endDate", endDate, TemporalType.DATE);

        List<Venta> ventas = query.getResultList();
        if (ventas.isEmpty()) {
            System.out.println("No hay ventas");
            return null;
        } else {
            System.out.println("Mostrando todas las ventas");
            for (Venta venta : ventas) {
                System.out.println(venta);
            }
            return ventas;
        }
    }
    
    public List<Venta> mostrarEntre(Calendar startDate, Calendar endDate,Cliente cliente) {
       // SELECT * FROM ventas WHERE idcliente = 2 AND fecha BETWEEN '2020-03-29' AND '2020-04-3'
        String jpq = "SELECT u FROM Venta u WHERE u.cliente = :cliente AND u.fecha BETWEEN :startDate AND :endDate";
        TypedQuery<Venta> query = em.createQuery(jpq, Venta.class);
        query.setParameter("cliente", cliente);
        query.setParameter("startDate", startDate, TemporalType.DATE);
        query.setParameter("endDate", endDate, TemporalType.DATE);

        List<Venta> ventas = query.getResultList();
        if (ventas.isEmpty()) {
            System.out.println("No hay ventas");
            return null;
        } else {
            System.out.println("Mostrando todas las ventas");
            for (Venta venta : ventas) {
                System.out.println(venta);
            }
            return ventas;
        }
    }

}
