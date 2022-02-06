package uteq.freelancer_mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uteq.freelancer_mvc.models.People;

public interface UserRepository extends JpaRepository<People, Long>{

}
