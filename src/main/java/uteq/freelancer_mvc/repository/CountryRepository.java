package uteq.freelancer_mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uteq.freelancer_mvc.models.Country;

public interface CountryRepository extends JpaRepository<Country, Integer>{

}
