/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosNegocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "ventas")
public class Venta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idCliente")
    private Cliente cliente;
    @Column(name = "descuento", nullable = false)
    private Float descuento;
    @Column(name = "montoFinal", nullable = false)
    private Float montoFinal;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta")
    private List<relProductoVentas> productos;

    public Venta() {
        productos = new ArrayList<>();
    }
    

    public Venta(Integer id, Date fecha, Cliente cliente, Float descuento, Float montoFinal, List<relProductoVentas> productos) {
        productos = new ArrayList<>();
        this.id = id;
        this.fecha = fecha;
        this.cliente = cliente;
        this.descuento = descuento;
        this.montoFinal = montoFinal;
        this.productos = productos;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Float getDescuento() {
        return descuento;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    public Float getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(Float montoFinal) {
        this.montoFinal = montoFinal;
    }   

    public List<relProductoVentas> getProductos() {
        return productos;
    }

    public void setProductos(List<relProductoVentas> productos) {
        this.productos = productos;
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
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "objetosNegocio.Venta[ id=" + id + " ]";
    }
    
  
    
}
