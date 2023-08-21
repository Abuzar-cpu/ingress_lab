package az.ingress.msorder.model.entities;

import az.ingress.msorder.model.enums.OrderStatus;
import az.ingress.msorder.model.enums.OrderType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Table(name = "orders")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
