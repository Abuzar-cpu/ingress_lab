package az.ingress.mscards.model.entities.requests;

import az.ingress.mscards.model.entities.CardStatus;
import az.ingress.mscards.model.entities.CardType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCardRequest {
    private String cardholderName;

    private CardType type;

    private CardStatus status = CardStatus.PENDING;
    private String pan;
}
