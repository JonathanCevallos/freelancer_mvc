package uteq.freelancer_mvc.service;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.freelancer_mvc.models.Pay;
import uteq.freelancer_mvc.repository.PayRepository;

@Service
public class PayService {
    @Autowired
    private PayRepository payRepository;

    //Este metodo permite listar todos los registro de la entidad.
    @Transactional
    public List<Pay> findAll() throws Exception {
        try {
            return payRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //Este metodo permite: Actualizar una factura mediante su ID.
    @Transactional
    public Pay findById(long id) throws Exception {
        try {
            Optional<Pay> entityOptional = payRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public Pay save(Pay entity) throws Exception {
        try {
            entity = payRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public Pay update(long id, Pay entity) throws Exception {
        try {
            Optional<Pay> entityOptional = payRepository.findById(id);
            Pay pay = entityOptional.get();
            pay = payRepository.save(entity);
            return pay;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    @Transactional
    public boolean delete(long id) throws Exception {
        try {
            if (payRepository.existsById(id)) {
                payRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
