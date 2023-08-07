package az.ingress.mstickets.models.responses;

import az.ingress.mstickets.models.entities.TicketStatus;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTicketByOrderIdResponse {
    private String orderId;
    private String assignee;
    private TicketStatus status;
    private String details;
    private LocalDate estimatedEndDate;
}
