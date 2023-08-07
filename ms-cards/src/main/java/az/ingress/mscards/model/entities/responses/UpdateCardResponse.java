package az.ingress.mscards.model.entities.responses;

import az.ingress.mscards.model.entities.CardStatus;
import az.ingress.mscards.model.entities.CardType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UpdateCardResponse {
    private String pan;
    private String cardholderName;
    private CardType type;
    private CardStatus status;
}
