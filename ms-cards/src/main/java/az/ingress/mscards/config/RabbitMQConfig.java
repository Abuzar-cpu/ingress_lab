package az.ingress.mscards.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    private final String cardQ;
    private final String cardDLQ;
    private final String cardQExchange;
    private final String cardDLQExchange;
    private final String cardQKey;
    private final String cardDLQKey;

    public RabbitMQConfig(@Value(value = "${rabbitmq.card.queue}") String cardQ, @Value(value = "${rabbitmq.card.dlq}") String cardDLQ) {
        this.cardQ = cardQ;
        this.cardDLQ = cardDLQ;
        this.cardDLQExchange = cardDLQ + "_Exchange";
        this.cardQExchange = cardQ + "_Exchange";
        this.cardQKey = cardQ + "_Key";
        this.cardDLQKey = cardDLQ + "_Key";
    }

    @Bean
    DirectExchange ticketDLQExchange() {
        return new DirectExchange(cardDLQExchange);
    }

    @Bean
    DirectExchange ticketQExchange() {
        return new DirectExchange(cardQExchange);
    }

    @Bean
    Queue ticketDLQ() {
        return QueueBuilder.durable(cardDLQ).build();
    }

    @Bean
    Queue ticketQ() {
        return QueueBuilder.durable(cardQ)
                .withArgument("x-dead-letter-exchange", cardDLQExchange)
                .withArgument("x-dead-letter-routing-key", cardDLQKey)
                .build();
    }

    @Bean
    Binding ticketDLQBinding() {
        return BindingBuilder.bind(ticketDLQ())
                .to(ticketDLQExchange())
                .with(cardDLQKey);
    }

    @Bean
    Binding ticketQBinding() {
        return BindingBuilder.bind(ticketQ())
                .to(ticketQExchange())
                .with(cardQKey);
    }
}
