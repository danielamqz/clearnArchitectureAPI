package co.com.bancolombia.consumer;

import co.com.bancolombia.model.producto.Producto;
import co.com.bancolombia.model.producto.gateways.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RestConsumer implements ProductoService/* implements Gateway from domain */{

    private final WebClient client;
    // these methods are an example that illustrates the implementation of WebClient.
    // You should use the methods that you implement from the Gateway from the domain.

    public Mono<ObjectResponse> testGet() {

        return client
            .get()
            .retrieve()
            .bodyToMono(ObjectResponse.class);

    }
    public Mono<ObjectResponse> testPost() {

        ObjectRequest request = ObjectRequest.builder()
            .val1("exampleval1")
            .val2("exampleval2")
            .build();

        return client
            .post()
            .body(Mono.just(request), ObjectRequest.class)
            .retrieve()
            .bodyToMono(ObjectResponse.class);
    }

    @Override
    public Flux<Producto> getProducto() {
        return client
                .get()
                .uri("https://fakestoreapi.com/products")
                .retrieve()
                .bodyToFlux(Producto.class);
    }

}