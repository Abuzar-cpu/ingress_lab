package az.ingress.mscards.dao;

import az.ingress.mscards.model.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    Card findCardByPan(String pan);

    Card findCardByOrderId(String orderId);
}
