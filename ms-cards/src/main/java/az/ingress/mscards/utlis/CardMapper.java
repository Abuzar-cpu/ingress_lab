package az.ingress.mscards.utlis;

import az.ingress.mscards.model.entities.Card;
import az.ingress.mscards.model.entities.requests.CreateCardRequest;
import az.ingress.mscards.model.entities.responses.CreateCardResponse;
import az.ingress.mscards.model.entities.responses.GetCardResponse;
import az.ingress.mscards.model.entities.responses.UpdateCardResponse;
import org.hibernate.sql.Update;

public class CardMapper {
    public static Card mapRequestToCard(CreateCardRequest request) {
        return Card.builder()
                .pan(PanGenerator.generate("861346", 16))
                .type(request.getCardType())
                .cardholderName(request.getCardholderName())
                .build();
    }
    public static CreateCardResponse mapEntityToResponse(Card card) {
        return CreateCardResponse.builder()
                .cardholderName(card.getCardholderName())
                .cardType(card.getType())
                .status(card.getStatus())
                .pan(card.getPan())
                .build();
    }
    public static UpdateCardResponse mapEntityToUpdateResponse(Card card) {
        return UpdateCardResponse.builder()
                .cardholderName(card.getCardholderName())
                .pan(card.getPan())
                .status(card.getStatus())
                .type(card.getType())
                .build();
    }
    public static GetCardResponse mapEntityToGetResponse(Card card) {
        return GetCardResponse.builder()
                .cardholderName(card.getCardholderName())
                .type(card.getType())
                .status(card.getStatus())
                .pan(card.getPan())
                .build();
    }
}
