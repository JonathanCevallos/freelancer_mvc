package uteq.freelancer_mvc.service;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.freelancer_mvc.models.People;
import uteq.freelancer_mvc.repository.PeopleRepository;

@Service
public class UserService {
    @Autowired
    private PeopleRepository peopleRepository;

    //Este metodo permite listar todos los registro de la entidad.
    @Transactional
    public List<People> findAll() throws Exception {
        try {
            return peopleRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //Este metodo permite: Actualizar una persona mediante su ID.
    @Transactional
    public People findById(long id) throws Exception {
        try {
            Optional<People> entityOptional = peopleRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public People save(People entity) throws Exception {
        try {
            entity = peopleRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public People update(long id, People entity) throws Exception {
        try {
            Optional<People> entityOptional = peopleRepository.findById(id);
            People user = entityOptional.get();
            user = peopleRepository.save(entity);
            return user;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    @Transactional
    public boolean delete(long id) throws Exception {
        try {
            if (peopleRepository.existsById(id)) {
                peopleRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
