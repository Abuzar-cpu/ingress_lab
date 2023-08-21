package az.ingress.mstickets.dao;

import az.ingress.mstickets.models.entities.TicketEntity;
import az.ingress.mstickets.models.entities.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
    TicketEntity findTicketEntityByOrderId(String orderId);

    List<TicketEntity> findTicketEntityByStatus(TicketStatus status);
}
