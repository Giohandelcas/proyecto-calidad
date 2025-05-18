package proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.datos.Datosregistrodetallespedido;
import proyecto.datos.Datosregistropedido;
import proyecto.entidades.Detallepedido;
import proyecto.entidades.Pedidos;
import proyecto.servicios.Clientesservicios;
import proyecto.servicios.Detallepedidoservicios;
import proyecto.servicios.Pedidosservicios;
import proyecto.servicios.Productosservicios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")  // Permite peticiones desde cualquier origen (útil para frontend)
public class PedidosControlador {

    @Autowired
    private Pedidosservicios pedidosservicios;

    @Autowired
    private Detallepedidoservicios detallepedidoservicios;

    @Autowired
    private Clientesservicios clientesservicios;

    @Autowired
    private Productosservicios productosservicios;

    @GetMapping
    public List<Pedidos> listarPedidos() {
        return pedidosservicios.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedidos> obtenerPedidoPorId(@PathVariable int id) {
        Optional<Pedidos> pedido = pedidosservicios.findById(id);
        return pedido.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pedidos> guardarPedido(@RequestBody Datosregistropedido pedido) {
        Pedidos nuevo = new Pedidos();
        nuevo.setClientes(clientesservicios.findById(pedido.idcliente()).get());
        nuevo.setFecha(LocalDate.now());
        Pedidos nuevoguardado = pedidosservicios.save(nuevo);
        for (Datosregistrodetallespedido detalle : pedido.detalles()) {
            Detallepedido nuevoDetalle = new Detallepedido();
            nuevoDetalle.setCantidad(detalle.cantidad());
            nuevoDetalle.setPedido(nuevoguardado);
            nuevoDetalle.setProducto(productosservicios.findById(detalle.idproducto()).get());
            detallepedidoservicios.save(nuevoDetalle);
        }
        return ResponseEntity.ok(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedidos> actualizarPedido(@PathVariable int id, @RequestBody Pedidos pedido) {
        Pedidos actualizado = pedidosservicios.update(id, pedido);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable int id) {
        pedidosservicios.delete(id);
        return ResponseEntity.noContent().build();
    }
}
