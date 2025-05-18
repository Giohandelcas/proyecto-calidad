package proyecto.repositorios;


import org.springframework.data.repository.CrudRepository;
import proyecto.entidades.Clientes;

public interface Clientesrepositorios extends CrudRepository<Clientes, Integer> {
}

