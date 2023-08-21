package az.ingress.msorder.model.responses;

import az.ingress.msorder.model.enums.CardType;
import az.ingress.msorder.model.enums.OrderStatus;
import az.ingress.msorder.model.enums.OrderType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateCardOrderResponse {
    private String cardholderName;
    private CardType cardType;
    private String orderId;
    private OrderStatus status;
    private OrderType orderType;
    private String shippingAddress;
    private String notes;
}
