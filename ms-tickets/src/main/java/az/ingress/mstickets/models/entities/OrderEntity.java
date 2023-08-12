package az.ingress.mstickets.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class OrderEntity {

    private Long id;

    private String orderId = UUID.randomUUID().toString();

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Enumerated(EnumType.STRING)
    private OrderType type;

    private String shippingAddress;

    private LocalDate orderDate = LocalDate.now();

    private String notes;
}
