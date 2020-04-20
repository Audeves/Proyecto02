/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosNegocio;

import java.io.Serializable;
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
 * @author Luis
 */
@Entity
@Table(name = "relProductoVentas")
public class relProductoVentas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;
    @ManyToOne(optional = false)
    @JoinColumn(name = "idVenta", nullable = false)
    private Venta venta;
    

    @Column(name = "precio", nullable = false)
    private Float precio;
    @Column(name = "cantidad", length = 11, nullable = false)
    private Integer cantidad;
    @Column(name = "montoTotal", nullable = false)
    private Float montoTotal;

    public relProductoVentas() {
    }
    
    

    public relProductoVentas( Producto producto, Venta venta, Float precio, Integer cantidad, Float montoTotal) {
        this.producto = producto;
        this.venta = venta;
        this.precio = precio;
        this.cantidad = cantidad;
        this.montoTotal = montoTotal;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Float montoTotal) {
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
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof relProductoVentas)) {
            return false;
        }
        relProductoVentas other = (relProductoVentas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "objetosNegocio.relProductoVentas[ id=" + id + " ]";
    }
    
}
