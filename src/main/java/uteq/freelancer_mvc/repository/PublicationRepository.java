package uteq.freelancer_mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import uteq.freelancer_mvc.models.Publication;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {

	@Query(value = "SELECT title as Servicio FROM publication WHERE id_professional = :idProfessional", nativeQuery = true)
	List<Publication> findByIdProfessional(@Param("idProfessional") Long idProfessional);
}
