package az.ingress.msorder.dataAccess;

import az.ingress.msorder.model.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<OrderEntity, Long> {
    OrderEntity findOrderByOrderId(String orderId);
}
