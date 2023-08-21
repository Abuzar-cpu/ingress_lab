package az.ingress.msorder.client;

import az.ingress.msorder.model.requests.CreateTicketRequest;
import az.ingress.msorder.model.responses.CreateTicketResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "ticket-service", url = "http://localhost:8082/api/v1/tickets/")
public interface TicketClient {

    @PostMapping("/")
    CreateTicketResponse createTicket(@RequestBody CreateTicketRequest request);
}
