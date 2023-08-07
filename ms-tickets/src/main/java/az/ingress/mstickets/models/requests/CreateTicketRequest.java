package az.ingress.mstickets.models.requests;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTicketRequest {
    private String orderId;
    private String assignee;
    private String details;
    private LocalDate estimatedEndDate;
}
