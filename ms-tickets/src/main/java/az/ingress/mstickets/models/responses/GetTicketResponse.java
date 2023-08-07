package az.ingress.mstickets.models.responses;

import az.ingress.mstickets.models.entities.TicketStatus;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GetTicketResponse {

    private String assignee;

    private TicketStatus status;

    private String details;

    private LocalDate createdAt;

    private LocalDate estimatedEndDate;
}
