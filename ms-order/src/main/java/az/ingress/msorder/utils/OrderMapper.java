package az.ingress.msorder.utils;

import az.ingress.msorder.model.entities.Order;
import az.ingress.msorder.model.entities.OrderStatus;
import az.ingress.msorder.model.entities.OrderType;
import az.ingress.msorder.model.requests.CreateOrderRequest;
import az.ingress.msorder.model.responses.CreateOrderResponse;
import az.ingress.msorder.model.responses.GetOrderResponse;

import java.time.LocalDate;
import java.util.UUID;

public class OrderMapper {
    public static Order mapCreateRequestToEntity(CreateOrderRequest request) {
        return Order.builder()
                .orderDate(LocalDate.now())
                .status(OrderStatus.OPEN)
                .orderId(UUID.randomUUID().toString())
                .type(request.getOrderType())
                .notes(request.getNotes())
                .shippingAddress(request.getShippingAddress())
                .build();
    }

    public static CreateOrderResponse mapEntityToCreateOrderResponse(Order order) {
        return CreateOrderResponse.builder()
                .orderType(order.getType())
                .orderId(order.getOrderId())
                .status(order.getStatus())
                .shippingAddress(order.getShippingAddress())
                .notes(order.getNotes())
                .build();
    }

    public static GetOrderResponse mapEntityToGetOrderResponse(Order order) {
        return GetOrderResponse.builder()
                .orderType(order.getType())
                .orderId(order.getOrderId())
                .shippingAddress(order.getShippingAddress())
                .orderDate(order.getOrderDate())
                .orderStatus(order.getStatus())
                .build();
    }
}
