package az.ingress.mscards.services.implementations;

import az.ingress.mscards.dao.CardRepository;
import az.ingress.mscards.model.entities.CardStatus;
import az.ingress.mscards.model.entities.requests.CreateCardRequest;
import az.ingress.mscards.model.entities.requests.UpdateCardRequest;
import az.ingress.mscards.model.entities.responses.CreateCardResponse;
import az.ingress.mscards.model.entities.responses.GetCardResponse;
import az.ingress.mscards.model.entities.responses.UpdateCardResponse;
import az.ingress.mscards.services.abstracts.CardService;
import az.ingress.mscards.utlis.CardMapper;
import exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.geom.RectangularShape;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardsServiceImpl implements CardService {
    private final CardRepository cardRepository;

    @Override
    public CreateCardResponse createCard(CreateCardRequest request) {
        // Call Ticket ms for ticket creation or use rabbit for messaging between ms
        var creating = CardMapper.mapRequestToCard(request);
        creating.setStatus(CardStatus.PENDING);
        var response = this.cardRepository.save(creating);
        return CardMapper.mapEntityToResponse(response);
    }

    @Override
    public GetCardResponse getCardByPan(String pan) {
        var response = this.cardRepository.findCardByPan(pan);
        if(response == null)
            throw new NotFoundException("Card not found");
        return CardMapper.mapEntityToGetResponse(response);
    }

    @Override
    public List<GetCardResponse> getCards() {
        var response = this.cardRepository.findAll();
        return response.stream().map(CardMapper::mapEntityToGetResponse).toList();
    }

    @Override
    public UpdateCardResponse updateCard(UpdateCardRequest request) {
        var card = this.cardRepository.findCardByPan(request.getPan());

        if(card == null)
            throw new NotFoundException("Card not found");

        card.setStatus(request.getStatus());
        card.setType(request.getType());
        card.setCardholderName(request.getCardholderName());
        var response = this.cardRepository.save(card);

        return CardMapper.mapEntityToUpdateResponse(response);
    }


}
