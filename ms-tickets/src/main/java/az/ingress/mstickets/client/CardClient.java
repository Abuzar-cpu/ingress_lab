package az.ingress.mstickets.client;

import az.ingress.mstickets.models.responses.GetCardResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "card-service", url = "http://localhost:8080/api/v1/cards/")
public interface CardClient {
    @GetMapping("order/{orderId}")
    GetCardResponse getCardByOrderId(@PathVariable String orderId);
}
