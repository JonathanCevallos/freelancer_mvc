package uteq.freelancer_mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.freelancer_mvc.models.Skill;
import uteq.freelancer_mvc.repository.SkillRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;

    //Este metodo permite lisatr todos los registro de la entidad.
    @Transactional
    public List<Skill> findAll() throws Exception {
        try {
            return skillRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Buscar un habilidad mediante su ID.
    @Transactional
    public Skill findById(int id) throws Exception {
        try {
            Optional<Skill> entityOptional = skillRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public Skill save(Skill entity) throws Exception {
        try {
            entity = skillRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public Skill update(int id, Skill entity) throws Exception {
        try {
            Optional<Skill> entityOptional = skillRepository.findById(id);
            Skill skill = entityOptional.get();
            skill = skillRepository.save(entity);
            return skill;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    @Transactional
    public boolean delete(int id) throws Exception {
        try {
            if (skillRepository.existsById(id)) {
                skillRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
