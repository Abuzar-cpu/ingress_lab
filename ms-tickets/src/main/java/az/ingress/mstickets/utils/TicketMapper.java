package az.ingress.mstickets.utils;

import az.ingress.mstickets.models.entities.TicketEntity;
import az.ingress.mstickets.models.entities.TicketStatus;
import az.ingress.mstickets.models.requests.CreateTicketRequest;
import az.ingress.mstickets.models.requests.UpdateTicketByOrderIdRequest;
import az.ingress.mstickets.models.responses.CreateTicketResponse;
import az.ingress.mstickets.models.responses.GetTicketResponse;
import az.ingress.mstickets.models.responses.UpdateTicketByOrderIdResponse;

import java.time.LocalDate;

public class TicketMapper {

    public static GetTicketResponse mapEntityToGetResponse(TicketEntity entity) {
        return GetTicketResponse.builder()
                .status(entity.getStatus())
                .assignee(entity.getAssignee())
                .createdAt(entity.getCreatedAt())
                .details(entity.getDetails())
                .estimatedEndDate(entity.getEstimatedEndDate())
                .build();
    }

    public static TicketEntity mapCreateRequestToEntity(CreateTicketRequest request) {
        return TicketEntity.builder()
                .orderId(request.getOrderId())
                .status(TicketStatus.OPEN)
                .createdAt(LocalDate.now())
                .estimatedEndDate(request.getEstimatedEndDate())
                .assignee(request.getAssignee())
                .details(request.getDetails())
                .build();
    }

    public static CreateTicketResponse mapEntityToCreateResponse(TicketEntity entity) {
        return CreateTicketResponse.builder()
                .createdAt(entity.getCreatedAt())
                .assignee(entity.getAssignee())
                .details(entity.getDetails())
                .estimatedEndDate(entity.getEstimatedEndDate())
                .status(entity.getStatus())
                .build();
    }

    public static void mapUpdateTicketByOrderIdRequestToEntity(TicketEntity ticket, UpdateTicketByOrderIdRequest request) {

        ticket.setAssignee(request.getAssignee() == null ? ticket.getAssignee() : request.getAssignee());
        ticket.setDetails(request.getDetails() == null ? ticket.getDetails() : request.getDetails());
        ticket.setStatus(request.getStatus() == null ? ticket.getStatus() : request.getStatus());
        ticket.setEstimatedEndDate(request.getEstimatedEndDate() == null ? ticket.getEstimatedEndDate() : request.getEstimatedEndDate());

    }

    public static UpdateTicketByOrderIdResponse mapEntityToUpdateTicketByOrderIdResponse(TicketEntity request) {

        return UpdateTicketByOrderIdResponse.builder()
                .orderId(request.getOrderId())
                .assignee(request.getAssignee())
                .details(request.getDetails())
                .estimatedEndDate(request.getEstimatedEndDate())
                .status(request.getStatus())
                .orderId(request.getOrderId())
                .build();
    }
}
