package proyecto.servicios;

import proyecto.entidades.Productos;

import java.util.List;
import java.util.Optional;

public interface Productosservicios {
    List<Productos> findAll();

    Optional<Productos> findById(int idproductos);
    Productos save(Productos x);
    Productos update(int idproductos, Productos x);
    void delete(int idproductos);


}
