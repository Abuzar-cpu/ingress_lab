package az.ingress.mscards.model.entities.requests;

import az.ingress.mscards.model.entities.CardType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCardRequest {
    @JsonIgnore
    private String orderId = UUID.randomUUID().toString();

    private String cardholderName;
    private CardType cardType;
}
