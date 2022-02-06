package uteq.freelancer_mvc.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.freelancer_mvc.models.Languaje;
import uteq.freelancer_mvc.repository.LanguajeRepository;
@Service
public class LanguajeService {
    @Autowired
    private LanguajeRepository languajeRepository;

    //Este metodo permite listar todos los registro de la entidad.
    @Transactional
    public List<Languaje> findAll() throws Exception {
        try {
            return languajeRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //Este metodo permite: Actualizar un idioma mediante su ID.
    @Transactional
    public Languaje findById(int id) throws Exception {
        try {
            Optional<Languaje> entityOptional = languajeRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public Languaje save(Languaje entity) throws Exception {
        try {
            entity = languajeRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public Languaje update(int id, Languaje entity) throws Exception {
        try {
            Optional<Languaje> entityOptional = languajeRepository.findById(id);
            Languaje languaje = entityOptional.get();
            languaje = languajeRepository.save(entity);
            return languaje;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    @Transactional
    public boolean delete(int id) throws Exception {
        try {
            if (languajeRepository.existsById(id)) {
                languajeRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
