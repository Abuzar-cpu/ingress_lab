package az.ingress.msorder.utils;

import az.ingress.msorder.model.entities.OrderEntity;
import az.ingress.msorder.model.enums.OrderStatus;
import az.ingress.msorder.model.requests.CreateCardOrderRequest;
import az.ingress.msorder.model.requests.CreateTicketRequest;
import az.ingress.msorder.model.responses.CreateCardOrderResponse;
import az.ingress.msorder.model.responses.GetOrderResponse;

import java.time.LocalDate;
import java.util.UUID;

public class OrderMapper {

    public static CreateTicketRequest mapOrderToCreateTicketRequest(OrderEntity order) {
        return CreateTicketRequest.builder()
                .estimatedEndDate(LocalDate.now().plusDays(14))
                .assignee("Unassigned")
                .orderId(order.getOrderId())
                .details(order.getNotes())
                .build();
    }

    public static OrderEntity mapCreateCardOrderRequestToEntity(CreateCardOrderRequest request) {
        return OrderEntity.builder()
                .orderDate(LocalDate.now())
                .status(OrderStatus.OPEN)
                .orderId(UUID.randomUUID().toString())
                .type(request.getOrderType())
                .notes(request.getNotes())
                .shippingAddress(request.getShippingAddress())
                .build();
    }

    public static CreateCardOrderResponse mapEntityToCreateCardOrderResponse(OrderEntity orderEntity) {
        return CreateCardOrderResponse.builder()
                .orderId(orderEntity.getOrderId())
                .orderType(orderEntity.getType())
                .orderId(orderEntity.getOrderId())
                .status(orderEntity.getStatus())
                .shippingAddress(orderEntity.getShippingAddress())
                .notes(orderEntity.getNotes())
                .build();
    }

    public static GetOrderResponse mapEntityToGetOrderResponse(OrderEntity orderEntity) {
        return GetOrderResponse.builder()
                .orderType(orderEntity.getType())
                .orderId(orderEntity.getOrderId())
                .shippingAddress(orderEntity.getShippingAddress())
                .orderDate(orderEntity.getOrderDate())
                .orderStatus(orderEntity.getStatus())
                .build();
    }
}
