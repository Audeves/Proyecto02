/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosNegocio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "provedores")
public class Provedor implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "rfc",length = 15, nullable = false)
    private String rfc;
    @Column(name = "nombre",length = 45, nullable = false)
    private String nombre;
    @Column(name = "direccion",length = 45, nullable = false)
    private String direccion;
    @Column(name = "telefono",length = 20, nullable = true)
    private String telefono;
    @Column(name = "paginaWeb",length = 500, nullable = true)
    private String paginaWeb;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "provedor")
    private List<Producto> productos;

    public Provedor() {
    }

    public Provedor(Integer id, String rfc, String nombre, String direccion, String telefono, String paginaWeb, List<Producto> productos) {
        this.id = id;
        this.rfc = rfc;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.paginaWeb = paginaWeb;
        this.productos = productos;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
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
        if (!(object instanceof Provedor)) {
            return false;
        }
        Provedor other = (Provedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.id + ". " + this.nombre;
    }
    
    public Object[] toArray() {
        return new Object[]{
          this.id,
          this.rfc,
          this.nombre,
          this.direccion,
          this.telefono,
          this.paginaWeb
        };

    }
    
}
