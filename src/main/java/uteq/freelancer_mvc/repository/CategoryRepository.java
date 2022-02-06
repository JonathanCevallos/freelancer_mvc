package uteq.freelancer_mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uteq.freelancer_mvc.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
