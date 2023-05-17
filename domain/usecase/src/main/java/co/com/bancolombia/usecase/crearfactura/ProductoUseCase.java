package co.com.bancolombia.usecase.crearfactura;
import co.com.bancolombia.model.producto.Producto;
import co.com.bancolombia.model.producto.gateways.ProductoRepo;
import co.com.bancolombia.model.producto.gateways.ProductoService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ProductoUseCase {
    private ProductoService serviceGateway;
    private ProductoRepo repoGateway;

    public Flux<Producto> obtenerProducto(){
        return serviceGateway.getProducto();
    }
    public Mono<Producto> guardarProducto(Producto producto){
        return repoGateway.saveProducto(producto);
    }
    public Mono<Boolean> poblar(){
        return serviceGateway.getProducto()
                .flatMap(repoGateway::saveProducto)
                .hasElements();
    }

}
