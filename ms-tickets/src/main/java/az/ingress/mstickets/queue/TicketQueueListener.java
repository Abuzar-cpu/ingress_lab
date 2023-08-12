package az.ingress.mstickets.queue;

import az.ingress.mstickets.models.entities.OrderEntity;
import az.ingress.mstickets.models.requests.CreateTicketRequest;
import az.ingress.mstickets.services.abstracts.TicketService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class TicketQueueListener {
    private final ObjectMapper objectMapper;
    private final TicketService ticketService;

    @SneakyThrows
    @RabbitListener(queues = "${rabbitmq.ticket.queue}")
    public void receiveMessage(String message) {
        var response = objectMapper.readValue(message, OrderEntity.class);
        ticketService.createTicket(
                CreateTicketRequest.builder()
                        .assignee("unassigned")
                        .details(response.getNotes())
                        .orderId(response.getOrderId())
                        .estimatedEndDate(LocalDate.of(2021, 12, 12))
                        .build()
        );
    }
}
