package proyecto.servicios;

import proyecto.entidades.Detallepedido;

import java.util.List;
import java.util.Optional;

public interface Detallepedidoservicios {
    List<Detallepedido> findAll();

    Optional<Detallepedido> findById(int iddetallepedido);
    Detallepedido save(Detallepedido x);
    Detallepedido update(int iddetallepedido, Detallepedido x);
    void delete(int iddetallepedido);
}
