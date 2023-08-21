package az.ingress.msorder.controller;

import az.ingress.msorder.model.requests.CreateCardOrderRequest;
import az.ingress.msorder.model.responses.CreateCardOrderResponse;
import az.ingress.msorder.model.responses.GetOrderResponse;
import az.ingress.msorder.services.abstracts.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/orders/card")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public CreateCardOrderResponse createOrder(CreateCardOrderRequest request) {
        return this.orderService.createCardOrder(request);
    }

    @GetMapping("/{orderId}")
    public GetOrderResponse getOrderByOrderId(@PathVariable String orderId) {
        return this.orderService.getOrderByOrderId(orderId);
    }
}
