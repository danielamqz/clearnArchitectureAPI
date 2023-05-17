package co.com.bancolombia.model.producto.gateways;

import co.com.bancolombia.model.producto.Producto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductoService {
    Flux<Producto> getProducto();
}
