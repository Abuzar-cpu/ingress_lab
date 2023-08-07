package az.ingress.mscards.model.entities.requests;

import az.ingress.mscards.model.entities.CardType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCardRequest {
    private String cardholderName;
    private CardType cardType;
}
