package proyecto.servicios;

import proyecto.entidades.Pedidos;


import java.util.List;
import java.util.Optional;

public interface Pedidosservicios {
    List<Pedidos> findAll();

    Optional<Pedidos> findById(int idpedido);
    Pedidos save(Pedidos x);
    Pedidos update(int idpedidos, Pedidos x);
    void delete(int idpedidos);


}