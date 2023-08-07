package az.ingress.mscards.controllers;

import az.ingress.mscards.model.entities.requests.CreateCardRequest;
import az.ingress.mscards.model.entities.requests.UpdateCardRequest;
import az.ingress.mscards.model.entities.responses.CreateCardResponse;
import az.ingress.mscards.model.entities.responses.GetCardResponse;
import az.ingress.mscards.model.entities.responses.UpdateCardResponse;
import az.ingress.mscards.services.abstracts.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cards/")
public class CardController {

    private final CardService cardService;

    @PostMapping("")
    public CreateCardResponse createCard(CreateCardRequest request) {
        return this.cardService.createCard(request);
    }

    @GetMapping("{pan}")
    public GetCardResponse getCardByPan(@PathVariable String pan) {
        return this.cardService.getCardByPan(pan);
    }

    @GetMapping("")
    public List<GetCardResponse> getAllCards() {
        return this.cardService.getCards();
    }

    @PutMapping("")
    public UpdateCardResponse updateCard(UpdateCardRequest request) {
        return this.cardService.updateCard(request);
    }
}
