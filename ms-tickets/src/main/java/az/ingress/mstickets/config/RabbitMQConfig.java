package az.ingress.mstickets.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    private final String ticketQ = "TICKET_Q";
    private final String ticketDLQ = "TICKET_DLQ";
    private final String ticketQExchange;
    private final String ticketDLQExchange;
    private final String ticketQKey;
    private final String ticketDLQKey;

    public RabbitMQConfig() {
//        this.ticketQ = ticketQ = "TICKET_Q";
//        this.ticketDLQ = ticketDLQ = "TICKET_DLQ"
        this.ticketDLQExchange= ticketDLQ + "_Exchange";
        this.ticketQExchange = ticketQ + "_Exchange";
        this.ticketQKey = ticketQ + "_Key";
        this.ticketDLQKey = ticketDLQ + "_Key";
    }

    @Bean
    DirectExchange ticketDLQExchange() {
        return new DirectExchange(ticketDLQExchange);
    }

    @Bean
    DirectExchange ticketQExchange() {
        return new DirectExchange(ticketQExchange);
    }

    @Bean
    Queue ticketDLQ() {
        return QueueBuilder.durable(ticketDLQ).build();
    }

    @Bean
    Queue ticketQ () {
        return QueueBuilder.durable(ticketQ)
                .withArgument("x-dead-letter-exchange", ticketDLQExchange)
                .withArgument("x-dead-letter-routing-key", ticketDLQKey)
                .build();
    }

    @Bean
    Binding ticketDLQBinding() {
        return BindingBuilder.bind(ticketDLQ())
                .to(ticketDLQExchange())
                .with(ticketDLQKey);
    }

    @Bean
    Binding ticketQBinding() {
        return BindingBuilder.bind(ticketQ())
                .to(ticketQExchange())
                .with(ticketQKey);
    }
}
