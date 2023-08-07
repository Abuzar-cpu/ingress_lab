package az.ingress.mscards.model.entities.responses;

import az.ingress.mscards.model.entities.CardStatus;
import az.ingress.mscards.model.entities.CardType;
import az.ingress.mscards.services.abstracts.CardService;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GetCardResponse {
    private String pan;
    private String cardholderName;
    private CardType type;
    private CardStatus status;
}
