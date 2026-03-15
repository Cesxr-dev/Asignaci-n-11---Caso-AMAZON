/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

/**
 *
 * @author demib
 */
@Entity
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Long id;
    
    @ElementCollection
    @CollectionTable(
            name = "cliente_telefonos",
            joinColumns = @JoinColumn(name = "cliente_id")
    )
    @Column(name = "telefono")
    private Set<String> telefonos;
    
    @ElementCollection
    @CollectionTable(
            name = "cliente_correos",
            joinColumns = @JoinColumn(name = "cliente_id")
    )
    @Column(name = "correo")
    private Set<String> correos;
    
    @Column(name = "fch_nac")
    private LocalDate fchNac;
    
    @Embedded
    private Nombre nombre;
    
    @OneToMany(mappedBy = "cliente")
    private Set<Pedido>pedidos;

    public Cliente() {
    }

    public Cliente(Long id, Set<String> telefonos, Set<String> correos, LocalDate fchNac, Nombre nombre, Set<Pedido> pedidos) {
        this.id = id;
        this.telefonos = telefonos;
        this.correos = correos;
        this.fchNac = fchNac;
        this.nombre = nombre;
        this.pedidos = pedidos;
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
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Cliente[ id=" + id + " ]";
    }
    
}
