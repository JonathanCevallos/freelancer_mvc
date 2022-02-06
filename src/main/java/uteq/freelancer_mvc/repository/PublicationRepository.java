package uteq.freelancer_mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uteq.freelancer_mvc.models.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Long>{

}
