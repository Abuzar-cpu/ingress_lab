package az.ingress.msorder.services.conctretes;

import az.ingress.msorder.client.TicketClient;
import az.ingress.msorder.dataAccess.OrderRepo;
import az.ingress.msorder.model.requests.CreateCardOrderRequest;
import az.ingress.msorder.model.responses.CreateCardOrderResponse;
import az.ingress.msorder.model.responses.GetOrderResponse;
import az.ingress.msorder.rabbit.QueueSender;
import az.ingress.msorder.services.abstracts.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static az.ingress.msorder.utils.OrderMapper.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final QueueSender queueSender;
    private final OrderRepo orderRepo;
    private final TicketClient ticketClient;
    @Value("${rabbitmq.ticket.queue}")
    private String cardQ;

    @Override
    public CreateCardOrderResponse createCardOrder(CreateCardOrderRequest request) {
        var order = this.orderRepo.save(mapCreateCardOrderRequestToEntity(request));
        request.setOrderId(order.getOrderId());
        this.queueSender.sendToTicketQueue(cardQ, request);

        System.out.println("Creating ticket: " + mapOrderToCreateTicketRequest(order));
        this.ticketClient.createTicket(mapOrderToCreateTicketRequest(order));
        // Setting response fields
        var response = mapEntityToCreateCardOrderResponse(order);
        response.setCardType(request.getCardType());
        response.setCardholderName(request.getCardholderName());
        return response;
    }

    @Override
    public GetOrderResponse getOrderByOrderId(String orderId) {
        var order = this.orderRepo.findOrderByOrderId(orderId);

        return mapEntityToGetOrderResponse(order);
    }
}
