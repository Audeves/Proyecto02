/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosNegocio;

import java.io.Serializable;
import java.util.ArrayList;
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

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "productos")
public class Producto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;
    @Column(name = "precioActual", nullable = false)
    private Float precioActual;
    @Column(name = "stock", length = 11, nullable = false)
    private Integer Stock;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idProvedor")
    private Provedor provedor;
    @ManyToOne(optional = false)
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<relProductoVentas> ventas;

    public Producto() {
        this.ventas = new ArrayList<>();
    }

    public Producto(Integer id, String nombre, Float precioActual, Integer Stock, Provedor provedor, Categoria categoria, List<relProductoVentas> ventas) {
        this.ventas = new ArrayList<>();
        this.id = id;
        this.nombre = nombre;
        this.precioActual = precioActual;
        this.Stock = Stock;
        this.provedor = provedor;
        this.categoria = categoria;
        this.ventas = ventas;
    }
 
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(Float precioActual) {
        this.precioActual = precioActual;
    }

    public Integer getStock() {
        return Stock;
    }

    public void setStock(Integer Stock) {
        this.Stock = Stock;
    }

    public Provedor getProvedor() {
        return provedor;
    }

    public void setProvedor(Provedor provedor) {
        this.provedor = provedor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<relProductoVentas> getVentas() {
        return ventas;
    }

    public void setVentas(List<relProductoVentas> ventas) {
        this.ventas = ventas;
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
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "objetosNegocio.Producto[ id=" + id + " ]";
    }
    
    public Object[] toArray() {
        return new Object[]{
            this.id,
            this.nombre,
            this.precioActual,
            this.Stock,
            this.provedor.getId(),
            this.categoria.getId()
        };

    }
    
}
