package az.ingress.msorder.model.responses;

import az.ingress.msorder.model.entities.OrderStatus;
import az.ingress.msorder.model.entities.OrderType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class GetOrderResponse {

    private String orderId;
    private OrderStatus orderStatus;
    private OrderType orderType;
    private String shippingAddress;
    private LocalDate orderDate;
    private String notes;
}
