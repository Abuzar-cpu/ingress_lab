package az.ingress.mscards.services.abstracts;

import az.ingress.mscards.model.entities.requests.CreateCardRequest;
import az.ingress.mscards.model.entities.requests.UpdateCardRequest;
import az.ingress.mscards.model.entities.responses.CreateCardResponse;
import az.ingress.mscards.model.entities.responses.GetCardResponse;
import az.ingress.mscards.model.entities.responses.UpdateCardResponse;

import java.util.List;

public interface CardService {
    CreateCardResponse createCard(CreateCardRequest request);

    GetCardResponse getCardByPan(String pan);

    List<GetCardResponse> getCards();

    UpdateCardResponse updateCard(UpdateCardRequest request);

    GetCardResponse getCardByOrderId(String orderId);
}
