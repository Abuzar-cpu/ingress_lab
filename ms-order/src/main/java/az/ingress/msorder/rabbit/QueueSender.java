package az.ingress.msorder.rabbit;

import az.ingress.msorder.model.entities.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class QueueSender {
    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    public void sendToTicketQueue(String queue, Order order) {
        this.amqpTemplate.convertAndSend(queue, objectMapper.writeValueAsString(order));
    }
}
