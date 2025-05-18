package proyecto.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "detallepedido")
public class Detallepedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddetalle")
    private int iddetalle;

    @ManyToOne
    @JoinColumn(name = "pedidos_idpedido")
    private Pedidos pedido;

    @ManyToOne
    @JoinColumn(name = "productos_idproducto")
    private Productos producto;

    @Column(name = "cantidad")
    private int cantidad;

    public Detallepedido() {
    }

    public Detallepedido(int iddetalle, Pedidos pedido, Productos producto, int cantidad) {
        this.iddetalle = iddetalle;
        this.pedido = pedido;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public int getIddetalle() {
        return iddetalle;
    }

    public void setIddetalle(int iddetalle) {
        this.iddetalle = iddetalle;
    }

    public Pedidos getPedido() {
        return pedido;
    }

    public void setPedido(Pedidos pedido) {
        this.pedido = pedido;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
