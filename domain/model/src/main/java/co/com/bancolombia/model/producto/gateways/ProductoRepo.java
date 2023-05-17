package co.com.bancolombia.model.producto.gateways;

import co.com.bancolombia.model.producto.Producto;
import reactor.core.publisher.Mono;

public interface ProductoRepo {
    Mono<Producto> saveProducto(Producto producto);
    Mono<Producto> deleteProducto(String id);
}
