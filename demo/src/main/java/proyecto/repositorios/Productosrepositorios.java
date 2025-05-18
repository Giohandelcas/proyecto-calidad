package proyecto.repositorios;


import org.springframework.data.repository.CrudRepository;
import proyecto.entidades.Productos;

public interface Productosrepositorios extends CrudRepository<Productos, Integer> {
}