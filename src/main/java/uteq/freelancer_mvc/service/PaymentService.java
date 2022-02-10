package uteq.freelancer_mvc.service;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.freelancer_mvc.models.Payment;
import uteq.freelancer_mvc.repository.PaymentRepository;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    //Este metodo permite listar todos los registro de la entidad.
    @Transactional
    public List<Payment> findAll() throws Exception {
        try {
            return paymentRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //Este metodo permite: Actualizar una factura mediante su ID.
    @Transactional
    public Payment findById(long id) throws Exception {
        try {
            Optional<Payment> entityOptional = paymentRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public Payment save(Payment entity) throws Exception {
        try {
            entity = paymentRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public Payment update(long id, Payment entity) throws Exception {
        try {
            Optional<Payment> entityOptional = paymentRepository.findById(id);
            Payment payment = entityOptional.get();
            payment = paymentRepository.save(entity);
            return payment;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    @Transactional
    public boolean delete(long id) throws Exception {
        try {
            if (paymentRepository.existsById(id)) {
                paymentRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
