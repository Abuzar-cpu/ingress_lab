package az.ingress.msorder.dataAccess;

import az.ingress.msorder.model.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    Order findOrderByOrderId(String orderId);
}
