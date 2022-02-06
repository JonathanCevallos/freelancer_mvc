package uteq.freelancer_mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.freelancer_mvc.models.Profesional;
import uteq.freelancer_mvc.repository.ProfesionalRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProfesionalService {
    @Autowired
    private ProfesionalRepository profesionalRepository;

    //Este metodo permite lisatr todos los profesionales registrados en la BD.
    @Transactional
    public List<Profesional> findAll() throws Exception{
        try {
            return profesionalRepository.findAll();
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Buscar un profesional mediante su ID.
    @Transactional
    public Profesional findById(Long id) throws Exception{
        try {
            Optional<Profesional> entityOptional = profesionalRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar un profesional.
    @Transactional
    public Profesional save(Profesional entity) throws Exception{
        try {
            entity = profesionalRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar un profesional mediante su ID.
    @Transactional
    public Profesional update(Long id, Profesional entity) throws Exception{
        try {
            Optional<Profesional> entityOptional = profesionalRepository.findById(id);
            Profesional profesional = entityOptional.get();
            profesional = profesionalRepository.save(entity);
            return  profesional;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar un profesional mediante su ID.
    @Transactional
    public boolean delete(Long id) throws Exception{
        try {
            if(profesionalRepository.existsById(id)){
                profesionalRepository.deleteById(id);
                return  true;
            }else {
                throw  new Exception();
            }
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

}