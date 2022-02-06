package uteq.freelancer_mvc.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uteq.freelancer_mvc.models.Plan;
import uteq.freelancer_mvc.repository.PlanRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PlanService {
    @Autowired
    private PlanRepository planRepository;

    //Este metodo permite lisatr todos los registro de la entidad.
    @Transactional
    public List<Plan> findAll() throws Exception {
        try {
            return planRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Buscar un plan mediante su ID.
    @Transactional
    public Plan findById(int id) throws Exception {
        try {
            Optional<Plan> entityOptional = planRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public Plan save(Plan entity) throws Exception {
        try {
            entity = planRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public Plan update(int id, Plan entity) throws Exception {
        try {
            Optional<Plan> entityOptional = planRepository.findById(id);
            Plan plan = entityOptional.get();
            plan = planRepository.save(entity);
            return plan;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    @Transactional
    public boolean delete(int id) throws Exception {
        try {
            if (planRepository.existsById(id)) {
                planRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
