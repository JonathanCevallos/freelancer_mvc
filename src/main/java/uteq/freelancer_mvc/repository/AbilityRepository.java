package uteq.freelancer_mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uteq.freelancer_mvc.models.Ability;

@Repository
public interface AbilityRepository extends JpaRepository<Ability,Integer> {

}