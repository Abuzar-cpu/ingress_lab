package az.ingress.mscards.model.entities.responses;

import az.ingress.mscards.model.entities.CardStatus;
import az.ingress.mscards.model.entities.CardType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCardResponse {
    private String pan;
    private String cardholderName;
    private CardType cardType;
    private CardStatus status;
}
