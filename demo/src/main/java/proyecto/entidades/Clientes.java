package proyecto.entidades;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="Clientes")
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcliente")
    private int idcliente;
    @Column(name = "nombre_cliente")
    @NotBlank(message = "nombre del cliente no puede estar vacio")
    private String nombre_cliente;
    @Column(name = "telefono")
    @NotBlank(message = "el telefono no puede ser vacio")
    private String telefono;
    @Column(name = "correo")
    @NotBlank(message = "el mensaje no puede estar vacio")
    @Email(message = "formato de correo invalido")
    private String correo;

    public Clientes() {
    }

    public Clientes(int idcliente, String nombre_cliente, String telefono, String correo) {
        this.idcliente = idcliente;
        this.nombre_cliente = nombre_cliente;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
