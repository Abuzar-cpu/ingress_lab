package az.ingress.mscards.utlis;

import az.ingress.mscards.model.entities.Card;
import az.ingress.mscards.model.entities.CardStatus;
import az.ingress.mscards.model.entities.CreateCardOrderRequest;
import az.ingress.mscards.model.entities.requests.CreateCardRequest;
import az.ingress.mscards.model.entities.responses.CreateCardResponse;
import az.ingress.mscards.model.entities.responses.GetCardResponse;
import az.ingress.mscards.model.entities.responses.UpdateCardResponse;

import java.time.LocalDate;

public class CardMapper {

    public static CreateCardRequest mapCreateCardOrderRequestToCreateCardRequest(CreateCardOrderRequest request) {
        return CreateCardRequest.builder()
                .orderId(request.getOrderId())
                .cardholderName(request.getCardholderName())
                .cardType(request.getCardType())
                .build();
    }

    public static Card mapRequestToCard(CreateCardRequest request) {
        return Card.builder()
                .orderId(request.getOrderId())
                .expireDate(LocalDate.now().plusYears(3))
                .status(CardStatus.PENDING)
                .pan(PanGenerator.generate("861346", 16))
                .cardholderName(request.getCardholderName())
                .type(request.getCardType())
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
