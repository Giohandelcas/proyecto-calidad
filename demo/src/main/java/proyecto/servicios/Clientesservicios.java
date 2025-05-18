package proyecto.servicios;

import org.springframework.stereotype.Service;
import proyecto.entidades.Clientes;

import java.util.List;
import java.util.Optional;

public interface Clientesservicios {
    List<Clientes> findAll();

    Optional<Clientes> findById(int idclientes);

    Clientes save(Clientes x);

    Clientes update(int idclientes, Clientes x);

    void delete(int idclientes);
}