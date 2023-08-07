package az.ingress.mstickets.dao;

import az.ingress.mstickets.models.entities.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
    TicketEntity findTicketEntityByOrderId(String orderId);
}
