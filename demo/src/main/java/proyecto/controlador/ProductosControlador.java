package proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.entidades.Productos;
import proyecto.servicios.Productosservicios;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")  // Opcional: permite llamadas desde otros orígenes (útil para frontend)
public class ProductosControlador {

    @Autowired
    private Productosservicios productosservicios;

    @GetMapping
    public List<Productos> listarProductos() {
        return productosservicios.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Productos> obtenerProductoPorId(@PathVariable int id) {
        Optional<Productos> producto = productosservicios.findById(id);
        return producto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Productos> guardarProducto(@RequestBody Productos producto) {
        Productos nuevoProducto = productosservicios.save(producto);
        return ResponseEntity.ok(nuevoProducto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Productos> actualizarProducto(@PathVariable int id, @RequestBody Productos producto) {
        Productos productoActualizado = productosservicios.update(id, producto);
        if (productoActualizado != null) {
            return ResponseEntity.ok(productoActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable int id) {
        productosservicios.delete(id);
        return ResponseEntity.noContent().build();
    }
}
