package uteq.freelancer_mvc.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.freelancer_mvc.models.Professional;
import uteq.freelancer_mvc.repository.ProfessionalRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessionalService {
    @Autowired
    private ProfessionalRepository professionalRepository;

    //Este metodo permite lisatr todos los profesionales registrados en la BD.
    @Transactional
    public List<Professional> findAll() throws Exception {
        try {
            return professionalRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Buscar un profesional mediante su ID.
    @Transactional
    public Professional findById(Long id) throws Exception {
        try {
            Optional<Professional> entityOptional = professionalRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar un profesional.
    @Transactional
    public Professional save(Professional entity) throws Exception {
        try {
            entity = professionalRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar un profesional mediante su ID.
    @Transactional
    public Professional update(Long id, Professional entity) throws Exception {
        try {
            Optional<Professional> entityOptional = professionalRepository.findById(id);
            Professional professional = entityOptional.get();
            professional = professionalRepository.save(entity);
            return professional;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar un profesional mediante su ID.
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (professionalRepository.existsById(id)) {
                professionalRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}