package az.ingress.mstickets.models.responses;

import az.ingress.mstickets.models.entities.CardStatus;
import az.ingress.mstickets.models.entities.CardType;
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
