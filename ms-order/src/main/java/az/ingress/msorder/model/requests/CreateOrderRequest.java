package az.ingress.msorder.model.requests;

import az.ingress.msorder.model.entities.OrderType;
import lombok.Data;

@Data
public class CreateOrderRequest {
    private OrderType orderType;
    private String shippingAddress;
    private String notes;
}
