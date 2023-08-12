package az.ingress.msorder.services.conctretes;

import az.ingress.msorder.dataAccess.OrderRepo;
import az.ingress.msorder.model.requests.CreateOrderRequest;
import az.ingress.msorder.model.responses.CreateOrderResponse;
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

    @Value("${rabbitmq.ticket.queue}")
    private String ticketQ;

    private final OrderRepo orderRepo;
    @Override
    public CreateOrderResponse createOrder(CreateOrderRequest request) {
        var order = this.orderRepo.save(mapCreateRequestToEntity(request));
        this.queueSender.sendToTicketQueue(ticketQ, order);
        return mapEntityToCreateOrderResponse(order);
    }

    @Override
    public GetOrderResponse getOrderByOrderId(String orderId) {
        var order = this.orderRepo.findOrderByOrderId(orderId);
        log.info(String.valueOf(order));
        var response = mapEntityToGetOrderResponse(order);
        log.info(String.valueOf(response));
        return  response;
    }
}
