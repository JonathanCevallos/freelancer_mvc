package uteq.freelancer_mvc.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uteq.freelancer_mvc.models.Proforma;
import uteq.freelancer_mvc.repository.ProformaRepository;

@Service
public class ProformaService {
    @Autowired
    private ProformaRepository proformaRepository;

    //Este metodo permite listar todos los registros de la entidad.
    @Transactional
    public List<Proforma> findAll() throws Exception {
        try {
            return proformaRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Buscar una cotización mediante su ID.
    @Transactional
    public Proforma findById(int id) throws Exception {
        try {
            Optional<Proforma> entityOptional = proformaRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public Proforma save(Proforma entity) throws Exception {
        try {
            entity = proformaRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public Proforma update(int id, Proforma entity) throws Exception {
        try {
            Optional<Proforma> entityOptional = proformaRepository.findById(id);
            Proforma proforma = entityOptional.get();
            proforma = proformaRepository.save(entity);
            return proforma;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    @Transactional
    public boolean delete(int id) throws Exception {
        try {
            if (proformaRepository.existsById(id)) {
                proformaRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}