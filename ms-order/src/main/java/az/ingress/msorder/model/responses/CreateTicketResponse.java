package az.ingress.msorder.model.responses;

import az.ingress.msorder.model.enums.TicketStatus;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTicketResponse {
    private String assignee;
    private TicketStatus status;
    private String details;
    private LocalDate createdAt;
    private LocalDate estimatedEndDate;
}
