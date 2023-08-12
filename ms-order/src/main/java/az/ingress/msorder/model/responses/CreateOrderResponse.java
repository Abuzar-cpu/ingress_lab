package az.ingress.msorder.model.responses;

import az.ingress.msorder.model.entities.OrderStatus;
import az.ingress.msorder.model.entities.OrderType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateOrderResponse {
    private String orderId;
    private OrderStatus status;
    private OrderType orderType;
    private String shippingAddress;
    private String notes;
}
