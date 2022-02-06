package uteq.freelancer_mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uteq.freelancer_mvc.models.Cotizacion;



@Repository
public interface CotizacionRepository extends JpaRepository<Cotizacion, Integer>{

}