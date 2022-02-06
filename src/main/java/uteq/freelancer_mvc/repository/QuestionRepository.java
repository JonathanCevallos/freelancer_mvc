package uteq.freelancer_mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uteq.freelancer_mvc.models.Question;

public interface QuestionRepository  extends JpaRepository<Question, Long>{

}
