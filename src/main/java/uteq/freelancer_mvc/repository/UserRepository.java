package uteq.freelancer_mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uteq.freelancer_mvc.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
