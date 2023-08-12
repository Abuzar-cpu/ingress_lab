package az.ingress.msorder.services.abstracts;

import az.ingress.msorder.model.requests.CreateOrderRequest;
import az.ingress.msorder.model.responses.CreateOrderResponse;
import az.ingress.msorder.model.responses.GetOrderResponse;

public interface OrderService {
    CreateOrderResponse createOrder(CreateOrderRequest request);
    GetOrderResponse getOrderByOrderId(String orderId);
}
