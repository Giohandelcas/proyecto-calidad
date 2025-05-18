package proyecto.servicios;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import proyecto.entidades.Clientes;
import proyecto.repositorios.Clientesrepositorios;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesserviciosImplementacion implements Clientesservicios {

    @Autowired
    private Clientesrepositorios repositorios;

    @Override
    @Transactional(readOnly = true)

    public List<Clientes> findAll() {
        return (List<Clientes>) repositorios.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Clientes> findById(int idclientes) {
        Optional<Clientes> cliente = repositorios.findById(idclientes);
        if(cliente.isPresent()) {
            return cliente;
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Clientes save(Clientes x) {
        Optional<Clientes> cliente = findById(x.getIdcliente());
        if(cliente.isPresent()) {
            return cliente.get();
        }
        return repositorios.save(x);
    }

    @Override
    @Transactional
    public Clientes update(int idclientes, Clientes x) {
        Optional<Clientes> elemento_buscado=repositorios.findById(idclientes);
        Clientes respuesta;
        if (elemento_buscado.isPresent()) {
            respuesta=elemento_buscado.get();
            respuesta.setNombre_cliente(x.getNombre_cliente());
            respuesta.setTelefono(x.getTelefono());
            respuesta.setCorreo(x.getCorreo());
            return repositorios.save(respuesta);
        }
        return null;
    }

    @Override
    @Transactional
    public void delete(int idclientes) {
        Optional<Clientes> buscado=findById(idclientes);
        if (buscado.isPresent()){
            repositorios.delete(buscado.get());
        }


    }
}
