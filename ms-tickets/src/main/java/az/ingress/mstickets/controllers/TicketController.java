package az.ingress.mstickets.controllers;

import az.ingress.mstickets.models.requests.CreateTicketRequest;
import az.ingress.mstickets.models.requests.UpdateTicketByOrderIdRequest;
import az.ingress.mstickets.models.responses.CreateTicketResponse;
import az.ingress.mstickets.models.responses.GetTicketResponse;
import az.ingress.mstickets.models.responses.UpdateTicketByOrderIdResponse;
import az.ingress.mstickets.services.abstracts.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tickets/")
public class TicketController {
    private final TicketService ticketService;

    @GetMapping("{orderId}")
    public GetTicketResponse getTicketResponse(@PathVariable String orderId) {
        return this.ticketService.getTicketByOrderId(orderId);
    }

    @PostMapping("")
    public CreateTicketResponse createTicket(CreateTicketRequest request) {
        return this.ticketService.createTicket(request);
    }

    @PutMapping("{orderId}")
    public UpdateTicketByOrderIdResponse updateTicket(@PathVariable String orderId, UpdateTicketByOrderIdRequest request) {
        return this.ticketService.updateTicket(orderId, request);
    }
}
