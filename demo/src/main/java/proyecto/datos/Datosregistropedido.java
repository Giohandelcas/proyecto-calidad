package proyecto.datos;

import java.util.List;

public record Datosregistropedido(int idcliente, List<Datosregistrodetallespedido> detalles) {

}
