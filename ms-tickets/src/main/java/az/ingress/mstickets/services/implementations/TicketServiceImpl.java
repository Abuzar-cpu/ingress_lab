package az.ingress.mstickets.services.implementations;

import az.ingress.mstickets.client.CardClient;
import az.ingress.mstickets.dao.TicketRepository;
import az.ingress.mstickets.exceptions.NotFoundException;
import az.ingress.mstickets.models.entities.CardStatus;
import az.ingress.mstickets.models.entities.TicketStatus;
import az.ingress.mstickets.models.requests.CreateTicketRequest;
import az.ingress.mstickets.models.requests.UpdateTicketByOrderIdRequest;
import az.ingress.mstickets.models.responses.CreateTicketResponse;
import az.ingress.mstickets.models.responses.GetTicketResponse;
import az.ingress.mstickets.models.responses.UpdateTicketByOrderIdResponse;
import az.ingress.mstickets.services.abstracts.TicketService;
import az.ingress.mstickets.utils.TicketMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static az.ingress.mstickets.utils.TicketMapper.mapEntityToGetResponse;

@RequiredArgsConstructor
@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final CardClient cardClient;

    @Override
    public CreateTicketResponse createTicket(CreateTicketRequest request) {
        System.out.println("Saving ticket: " + request);

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
        if (ticket.getStatus() != TicketStatus.DONE && request.getStatus() == TicketStatus.DONE) {
            var card = this.cardClient.getCardByOrderId(orderId);
            if (card.getStatus() != CardStatus.DONE)
                throw new NotFoundException("Card not found");
        }

        TicketMapper.mapUpdateTicketByOrderIdRequestToEntity(ticket, request);

        var response = this.ticketRepository.save(ticket);
        return TicketMapper.mapEntityToUpdateTicketByOrderIdResponse(response);
    }

    public GetTicketResponse getTicketByOrderId(String orderId) {
        var response = this.ticketRepository.findTicketEntityByOrderId(orderId);
        if (response == null)
            throw new NotFoundException("Ticket not found");

        return mapEntityToGetResponse(response);
    }

    @Override
    public List<GetTicketResponse> getTicketByStatus(TicketStatus status) {
        var response = this.ticketRepository.findTicketEntityByStatus(status);
        if (response == null)
            throw new NotFoundException("Ticket not found");
        return response.stream().map(TicketMapper::mapEntityToGetResponse).toList();
    }
}
