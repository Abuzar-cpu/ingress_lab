package az.ingress.msorder.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.time.LocalDate;

@Table(name = "orders")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderId;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private String shippingAddress;
    private LocalDate orderDate;
    private String notes;
}
