package az.ingress.mstickets.services.implementations;

import az.ingress.mstickets.dao.TicketRepository;
import az.ingress.mstickets.exceptions.NotFoundException;
import az.ingress.mstickets.models.requests.CreateTicketRequest;
import az.ingress.mstickets.models.requests.UpdateTicketByOrderIdRequest;
import az.ingress.mstickets.models.responses.CreateTicketResponse;
import az.ingress.mstickets.models.responses.GetTicketResponse;
import az.ingress.mstickets.models.responses.UpdateTicketByOrderIdResponse;
import az.ingress.mstickets.services.abstracts.TicketService;
import az.ingress.mstickets.utils.TicketMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;

    @Override
    public CreateTicketResponse createTicket(CreateTicketRequest request) {
        var ticket = TicketMapper.mapCreateRequestToEntity(request);
        var response = this.ticketRepository.save(ticket);
        return TicketMapper.mapEntityToCreateResponse(response);
    }

    @Override
    public UpdateTicketByOrderIdResponse updateTicket(String orderId, UpdateTicketByOrderIdRequest request) {
        var ticket = this.ticketRepository.findTicketEntityByOrderId(orderId);
        if (ticket == null)
            throw new NotFoundException("Ticket not found");

        // Go and check card that has associated order ID
        TicketMapper.mapUpdateTicketByOrderIdRequestToEntity(ticket, request);

        var response = this.ticketRepository.save(ticket);
        return TicketMapper.mapEntityToUpdateTicketByOrderIdResponse(response);
    }

    public GetTicketResponse getTicketByOrderId(String orderId) {
        var response = this.ticketRepository.findTicketEntityByOrderId(orderId);
        if (response == null)
            throw new NotFoundException("Ticket not found");

        return TicketMapper.mapEntityToGetResponse(response);
    }
}
