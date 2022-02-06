package uteq.freelancer_mvc.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uteq.freelancer_mvc.models.Qualification;
import uteq.freelancer_mvc.repository.QualificationRepository;

@Service
public class QualificationService {
    @Autowired
    private QualificationRepository qualificationRepository;

    //Este metodo permite listar todos los registro de la entidad.
    @Transactional
    public List<Qualification> findAll() throws Exception {
        try {
            return qualificationRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Buscar una calificacion mediante su ID.
    @Transactional
    public Qualification findById(Long id) throws Exception {
        try {
            Optional<Qualification> entityOptional = qualificationRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public Qualification save(Qualification entity) throws Exception {
        try {
            entity = qualificationRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public Qualification update(Long id, Qualification entity) throws Exception {
        try {
            Optional<Qualification> entityOptional = qualificationRepository.findById(id);
            Qualification qualification = entityOptional.get();
            qualification = qualificationRepository.save(entity);
            return qualification;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (qualificationRepository.existsById(id)) {
                qualificationRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
