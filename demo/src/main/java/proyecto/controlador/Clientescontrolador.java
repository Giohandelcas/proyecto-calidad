package proyecto.controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import proyecto.entidades.Clientes;
import proyecto.servicios.Clientesservicios;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/clientes")
public class Clientescontrolador {

    @Autowired

    private Clientesservicios clientesservicios;


    //Listar
    @GetMapping("/listar")
    public ResponseEntity<List<Clientes>> listar(){
        List<Clientes> clientes = clientesservicios.findAll();
        return ResponseEntity.ok(clientes);
    }
    @PostMapping("/guardar")
    public ResponseEntity<Clientes> guardar(@RequestBody Clientes x, UriComponentsBuilder builder){
        Clientes respuesta = clientesservicios.save(x);
        return ResponseEntity.created(builder.path("/api/clientes/{id}").buildAndExpand(respuesta.getIdcliente()).toUri()).body(respuesta);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Clientes> listarcliente(@PathVariable int id){
        Clientes cliente = clientesservicios.findById(id).get();
        return ResponseEntity.ok(cliente);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Clientes> actualizar(@RequestBody Clientes x, @PathVariable int id){
        Clientes respuesta = clientesservicios.update(id, x);
        return ResponseEntity.ok(respuesta);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id){
        clientesservicios.delete(id);
        return ResponseEntity.noContent().build();
    }
}
