package az.ingress.msorder.controller;

import az.ingress.msorder.model.requests.CreateOrderRequest;
import az.ingress.msorder.model.responses.CreateOrderResponse;
import az.ingress.msorder.model.responses.GetOrderResponse;
import az.ingress.msorder.services.abstracts.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/orders/")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public CreateOrderResponse createOrder(CreateOrderRequest request)  {
        return this.orderService.createOrder(request);
    }

    @GetMapping("/{orderId}")
    public GetOrderResponse getOrderByOrderId(@PathVariable String orderId) {
        return this.orderService.getOrderByOrderId(orderId);
    }
}
