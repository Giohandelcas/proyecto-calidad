package proyecto.entidades;

import jakarta.persistence.*;
import java.math.BigDecimal;
@Entity
@Table(name="productos")
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproducto")
    private int idproducto;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @Column(name = "valor_producto")
    private BigDecimal valorProducto;

    @Column(name = "descripcion_producto")
    private String descripcionProducto;

    @Column(name = "estado_producto")
    private String estadoProducto;

    public Productos() {
    }

    public Productos(int idproducto, String nombreProducto, BigDecimal valorProducto, String descripcionProducto, String estadoProducto) {
        this.idproducto = idproducto;
        this.nombreProducto = nombreProducto;
        this.valorProducto = valorProducto;
        this.descripcionProducto = descripcionProducto;
        this.estadoProducto = estadoProducto;
    }

    // Getters and Setters
    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;

    }

    public BigDecimal getValorProducto() {
        return valorProducto;
    }

    public void setValorProducto(BigDecimal valorProducto) {
        this.valorProducto = valorProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(String estadoProducto) {
        this.estadoProducto = estadoProducto;
    }
}


