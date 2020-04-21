/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosNegocio;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Mario
 */
@Entity
@Table(name="rel_productosventas")
public class RelProductosVentas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="idrel_productosventa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="precio")
    private float precio;

    @Column(name="cantidad")
    private int cantidad;
    
    @Column(name = "montototal")
    private float montoTotal;

    @ManyToOne
    @JoinColumn(name = "idproducto", nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "idventa", nullable = false)
    private Venta venta;

    public RelProductosVentas() {
    }

    public RelProductosVentas(float precio, int cantidad, float montoTotal, Producto producto, Venta venta) {
        this.precio = precio;
        this.cantidad = cantidad;
        this.montoTotal = montoTotal;
        this.producto = producto;
        this.venta = venta;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Float.floatToIntBits(this.precio);
        hash = 37 * hash + this.cantidad;
        hash = 37 * hash + Float.floatToIntBits(this.montoTotal);
        hash = 37 * hash + Objects.hashCode(this.producto);
        hash = 37 * hash + Objects.hashCode(this.venta);
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
        final RelProductosVentas other = (RelProductosVentas) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.precio) != Float.floatToIntBits(other.precio)) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (Float.floatToIntBits(this.montoTotal) != Float.floatToIntBits(other.montoTotal)) {
            return false;
        }
        if (!Objects.equals(this.producto, other.producto)) {
            return false;
        }
        if (!Objects.equals(this.venta, other.venta)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RelProductosVentas{" + "id=" + id + ", precio=" + precio + ", cantidad=" + cantidad + ", montoTotal=" + montoTotal + ", producto=" + producto + ", venta=" + venta + '}';
    }
    
    

    
}
