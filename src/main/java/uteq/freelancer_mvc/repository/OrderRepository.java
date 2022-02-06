package uteq.freelancer_mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uteq.freelancer_mvc.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
