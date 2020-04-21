/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosNegocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Mario
 */
@Entity
@Table(name ="proveedores")
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name ="idproveedor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 
    @Column(name ="rfc")
    private String rfc;
    @Column(name ="nombre")
    private String nombre;
    @Column(name ="direccion")
    private String direccion;
    @Column(name ="telefono")
    private String telefono;
    @Column(name ="paginaweb")
    private String paginaWeb;
    @OneToMany(mappedBy = "proveedor",cascade = CascadeType.ALL)//(fetch = FetchType.LAZY)
    private List<Producto> categorias;
    

     public Proveedor(){
        categorias = new ArrayList<Producto>();
    }
     
    public Proveedor(String rfc, String nombre, String direccion, String telefono, String paginaWeb) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.paginaWeb = paginaWeb;
        categorias = new ArrayList<Producto>();
    }
    
   

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.rfc);
        hash = 79 * hash + Objects.hashCode(this.nombre);
        hash = 79 * hash + Objects.hashCode(this.direccion);
        hash = 79 * hash + Objects.hashCode(this.telefono);
        hash = 79 * hash + Objects.hashCode(this.paginaWeb);
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
        final Proveedor other = (Proveedor) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.rfc, other.rfc)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.paginaWeb, other.paginaWeb)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "id=" + id + ", rfc=" + rfc + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", paginaWeb=" + paginaWeb + '}';
    }
    

    
}
