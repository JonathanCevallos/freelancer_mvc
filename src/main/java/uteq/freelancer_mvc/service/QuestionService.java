package uteq.freelancer_mvc.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.freelancer_mvc.models.Question;
import uteq.freelancer_mvc.repository.QuestionRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    //Este metodo permite lisatr todos los registro de la entidad.
    @Transactional
    public List<Question> findAll() throws Exception {
        try {
            return questionRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Buscar un pregunta mediante su ID.
    @Transactional
    public Question findById(Long id) throws Exception {
        try {
            Optional<Question> entityOptional = questionRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public Question save(Question entity) throws Exception {
        try {
            entity = questionRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public Question update(Long id, Question entity) throws Exception {
        try {
            Optional<Question> entityOptional = questionRepository.findById(id);
            Question question = entityOptional.get();
            question = questionRepository.save(entity);
            return question;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (questionRepository.existsById(id)) {
                questionRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
