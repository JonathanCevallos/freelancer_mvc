package uteq.freelancer_mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uteq.freelancer_mvc.models.SubCategoria;



@Repository
public interface SubCategoriaRepository extends JpaRepository<SubCategoria, Integer>{

}