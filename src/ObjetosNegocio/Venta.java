/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosNegocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Luis
 */
@Entity
@Table(name ="ventas")
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idventa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Calendar fecha;

    @Column(name = "descuento")
    private float descuento;

    @Column(name = "montofinal")
    private float montoFinal;

    @ManyToOne
    @JoinColumn(name = "idcliente", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)//(fetch = FetchType.LAZY)
    private List<RelProductosVentas> productos;


    public Venta() {
         productos = new ArrayList<RelProductosVentas>();
    }
        
    public Venta(Calendar fecha, float descuento, float montoFinal, Cliente cliente) {
        this.fecha = fecha;
        this.descuento = descuento;
        this.montoFinal = montoFinal;
        this.cliente = cliente;
         productos = new ArrayList<RelProductosVentas>();
    }
    
    

     
     
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public float getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(float montoFinal) {
        this.montoFinal = montoFinal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + this.id;
        hash = 13 * hash + Objects.hashCode(this.fecha);
        hash = 13 * hash + Float.floatToIntBits(this.descuento);
        hash = 13 * hash + Float.floatToIntBits(this.montoFinal);
        hash = 13 * hash + Objects.hashCode(this.cliente);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Venta other = (Venta) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.descuento) != Float.floatToIntBits(other.descuento)) {
            return false;
        }
        if (Float.floatToIntBits(this.montoFinal) != Float.floatToIntBits(other.montoFinal)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", fecha=" + fecha + ", descuento=" + descuento + ", montoFinal=" + montoFinal + ", cliente=" + cliente + '}';
    }
    
    
    

}
