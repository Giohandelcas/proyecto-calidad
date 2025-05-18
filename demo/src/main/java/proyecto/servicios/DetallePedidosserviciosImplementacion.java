package proyecto.servicios;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import proyecto.entidades.Detallepedido;
import proyecto.repositorios.Detallepedidorepositorios;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidosserviciosImplementacion implements Detallepedidoservicios {

    @Autowired
    private Detallepedidorepositorios repositorios;

    @Override
    @Transactional(readOnly = true)
    public List<Detallepedido> findAll() {
        return (List<Detallepedido>) repositorios.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Detallepedido> findById(int iddetalle) {
        return repositorios.findById(iddetalle);
    }

    @Override
    @Transactional
    public Detallepedido save(Detallepedido x) {
        Optional<Detallepedido> detalle = findById(x.getIddetalle());
        if (detalle.isPresent()) {
            return detalle.get();
        }
        return repositorios.save(x);
    }

    @Override
    @Transactional
    public Detallepedido update(int iddetalle, Detallepedido x) {
        Optional<Detallepedido> elemento_buscado = repositorios.findById(iddetalle);
        if (elemento_buscado.isPresent()) {
            Detallepedido respuesta = elemento_buscado.get();
            respuesta.setIddetalle(x.getIddetalle ());
            respuesta.setPedido(x.getPedido ());
            respuesta.setProducto(x.getProducto());
            respuesta.setCantidad(x.getCantidad());
            return repositorios.save(respuesta);
        }
        return null;
    }

    @Override
    @Transactional
    public void delete(int iddetalle) {
        Optional<Detallepedido> buscado = findById(iddetalle);
        buscado.ifPresent(repositorios::delete);
    }
}
