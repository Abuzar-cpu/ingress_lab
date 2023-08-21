package az.ingress.mscards.queue;

import az.ingress.mscards.model.entities.CreateCardOrderRequest;
import az.ingress.mscards.services.abstracts.CardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static az.ingress.mscards.utlis.CardMapper.mapCreateCardOrderRequestToCreateCardRequest;

@Component
@RequiredArgsConstructor
public class RabbitMQListener {
    private final ObjectMapper objectMapper;
    private final CardService cardService;

    @SneakyThrows
    @RabbitListener(queues = "${rabbitmq.card.queue}")
    public void receiveMessage(String message) {
        var response = objectMapper.readValue(message, CreateCardOrderRequest.class);

        System.out.println("Creating card: " + response);
        this.cardService.createCard(mapCreateCardOrderRequestToCreateCardRequest(response));
    }
}
