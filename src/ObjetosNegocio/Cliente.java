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
 * @author Luis
 */
@Entity
@Table(name ="clientes")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name ="idcliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="rfc")
    private String rfc;

    @Column(name ="nombre")
    private String nombre;

    @Column(name ="direccion")
    private String direccion;

    @Column(name ="telefono1")
    private String telefono1;

    @Column(name ="telefono2")
    private String telefono2;

    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)//(fetch = FetchType.LAZY)
    private List<Venta> ventas;

    public Cliente() {
        ventas = new ArrayList<Venta>();
    }

    public Cliente(String rfc, String nombre, String direccion, String telefono1, String telefono2) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        ventas = new ArrayList<Venta>();
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

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.id;
        hash = 17 * hash + Objects.hashCode(this.rfc);
        hash = 17 * hash + Objects.hashCode(this.nombre);
        hash = 17 * hash + Objects.hashCode(this.direccion);
        hash = 17 * hash + Objects.hashCode(this.telefono1);
        hash = 17 * hash + Objects.hashCode(this.telefono2);
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
        final Cliente other = (Cliente) obj;
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
        if (!Objects.equals(this.telefono1, other.telefono1)) {
            return false;
        }
        if (!Objects.equals(this.telefono2, other.telefono2)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", rfc=" + rfc + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono1=" + telefono1 + ", telefono2=" + telefono2 + '}';
    }

    
    

    
}
