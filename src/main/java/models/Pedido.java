/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 *
 * @author demib
 */
@Entity
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedido_id")
    private Long id;
    
 
    @OneToMany(mappedBy = "pedido")
    private Set<PedidoProducto> productos;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Pedido() {
    }

    public Pedido(Long id, Set<PedidoProducto> productos, Cliente cliente) {
        this.id = id;
        this.productos = productos;
        this.cliente = cliente;
    }

    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    //Metodo que calcula el total ( subtotal + iva )
    public BigDecimal getTotal() {
        BigDecimal sub = getSubtotal();
        
        return sub.add(sub.multiply(new BigDecimal("0.16")));
    }

    public BigDecimal getSubtotal() {
        return productos.stream()
                .map(PedidoProducto::getImporte)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    //Mostrar iva por separado
    public BigDecimal getIva() {
        return getSubtotal().multiply(new BigDecimal("0.16"));
    }

    

    public Set<PedidoProducto> getProductos() {
        return productos;
    }

    public void setProductos(Set<PedidoProducto> productos) {
        this.productos = productos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Pedido[ id=" + id + " ]";
    }
    
}
