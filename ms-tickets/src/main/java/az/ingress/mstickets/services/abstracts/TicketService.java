package az.ingress.mstickets.services.abstracts;

import az.ingress.mstickets.models.entities.TicketStatus;
import az.ingress.mstickets.models.requests.CreateTicketRequest;
import az.ingress.mstickets.models.requests.UpdateTicketByOrderIdRequest;
import az.ingress.mstickets.models.responses.CreateTicketResponse;
import az.ingress.mstickets.models.responses.GetTicketResponse;
import az.ingress.mstickets.models.responses.UpdateTicketByOrderIdResponse;

import java.util.List;

public interface TicketService {
    // Create
    // Read
    // Update
    // Delete

    CreateTicketResponse createTicket(CreateTicketRequest request);

    UpdateTicketByOrderIdResponse updateTicket(String orderId, UpdateTicketByOrderIdRequest request);

    GetTicketResponse getTicketByOrderId(String orderId);

    List<GetTicketResponse> getTicketByStatus(TicketStatus status);
}
