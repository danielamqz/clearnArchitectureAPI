package co.com.bancolombia.model.producto;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Producto {

    private int id;
    private String name;
    private int precio;
    private int stockQuantity;
}
