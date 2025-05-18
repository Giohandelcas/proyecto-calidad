package proyecto.servicios;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import proyecto.entidades.Pedidos;
import proyecto.repositorios.Pedidosrepositorios;

import java.util.List;
import java.util.Optional;

@Service
public class PedidosserviciosImplementacion implements Pedidosservicios {

    @Autowired
    private Pedidosrepositorios repositorios;

    @Override
    @Transactional(readOnly = true)
    public List<Pedidos> findAll() {
        return (List<Pedidos>) repositorios.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Pedidos> findById(int idpedido) {
        return repositorios.findById(idpedido);
    }

    @Override
    @Transactional
    public Pedidos save(Pedidos x) {
        Optional<Pedidos> pedido = findById(x.getIdpedido());
        if (pedido.isPresent()) {
            return pedido.get();
        }
        return repositorios.save(x);
    }

    @Override
    @Transactional
    public Pedidos update(int idpedido, Pedidos x) {
        Optional<Pedidos> elemento_buscado = repositorios.findById(idpedido);
        if (elemento_buscado.isPresent()) {
            Pedidos respuesta = elemento_buscado.get();
            respuesta.setFecha(x.getFecha());
            respuesta.setClientes(x.getClientes());
            return repositorios.save(respuesta);
        }
        return null;
    }

    @Override
    @Transactional
    public void delete(int idpedido) {
        Optional<Pedidos> buscado = findById(idpedido);
        buscado.ifPresent(pedido -> repositorios.delete(pedido));
    }
}

