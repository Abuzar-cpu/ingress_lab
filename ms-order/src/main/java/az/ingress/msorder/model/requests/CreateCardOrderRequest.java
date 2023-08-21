package az.ingress.msorder.model.requests;

import az.ingress.msorder.model.enums.CardType;
import az.ingress.msorder.model.enums.OrderType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateCardOrderRequest {
    private String orderId;
    private String cardholderName;
    private CardType cardType;
    private OrderType orderType;
    private String shippingAddress;
    private String notes;
}
