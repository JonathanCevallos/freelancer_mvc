package uteq.freelancer_mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.freelancer_mvc.models.Ability;
import uteq.freelancer_mvc.repository.AbilityRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AbilityService {
    @Autowired
    private AbilityRepository abilityRepository;

    //Este metodo permite lisatr todos los registro de la entidad.
    @Transactional
    public List<Ability> findAll() throws Exception {
        try {
            return abilityRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Buscar un habilidad mediante su ID.
    @Transactional
    public Ability findById(int id) throws Exception {
        try {
            Optional<Ability> entityOptional = abilityRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public Ability save(Ability entity) throws Exception {
        try {
            entity = abilityRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public Ability update(int id, Ability entity) throws Exception {
        try {
            Optional<Ability> entityOptional = abilityRepository.findById(id);
            Ability ability = entityOptional.get();
            ability = abilityRepository.save(entity);
            return ability;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    @Transactional
    public boolean delete(int id) throws Exception {
        try {
            if (abilityRepository.existsById(id)) {
                abilityRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
