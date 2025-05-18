package proyecto.servicios;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import proyecto.entidades.Productos;
import proyecto.repositorios.Productosrepositorios;

import java.util.List;
import java.util.Optional;

@Service
public class ProductosserviciosImplementacion implements Productosservicios {

    @Autowired
    private Productosrepositorios repositorios;

    @Override
    @Transactional(readOnly = true)
    public List<Productos> findAll() {
        return (List<Productos>) repositorios.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Productos> findById(int idproducto) {
        return repositorios.findById(idproducto);
    }

    @Override
    @Transactional
    public Productos save(Productos x) {
        Optional<Productos> producto = findById(x.getIdproducto());
        if(producto.isPresent()) {
            return producto.get();
        }
        return repositorios.save(x);
    }

    @Override
    @Transactional
    public Productos update(int idproducto, Productos x) {
        Optional<Productos> elemento_buscado = repositorios.findById(idproducto);
        if (elemento_buscado.isPresent()) {
            Productos respuesta = elemento_buscado.get();
            respuesta.setNombreProducto(x.getNombreProducto());
            respuesta.setValorProducto(x.getValorProducto());
            respuesta.setDescripcionProducto(x.getDescripcionProducto());
            respuesta.setEstadoProducto(x.getEstadoProducto());
            return repositorios.save(respuesta);
        }
        return null;
    }

    @Override
    @Transactional
    public void delete(int idproducto) {
        Optional<Productos> buscado = findById(idproducto);
        buscado.ifPresent(producto -> repositorios.delete(producto));
    }
}

