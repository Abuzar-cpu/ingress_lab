package az.ingress.msorder.model.requests;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CreateTicketRequest {
    private String orderId;
    private String assignee;
    private String details;
    private LocalDate estimatedEndDate;
}
