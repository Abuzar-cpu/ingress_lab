package az.ingress.msorder.services.abstracts;

import az.ingress.msorder.model.requests.CreateCardOrderRequest;
import az.ingress.msorder.model.responses.CreateCardOrderResponse;
import az.ingress.msorder.model.responses.GetOrderResponse;

public interface OrderService {
    CreateCardOrderResponse createCardOrder(CreateCardOrderRequest request);

    GetOrderResponse getOrderByOrderId(String orderId);
}
