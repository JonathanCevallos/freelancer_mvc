package uteq.freelancer_mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.freelancer_mvc.models.Pregunta;
import uteq.freelancer_mvc.repository.PreguntaRepository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PreguntaService {
	@Autowired
    private PreguntaRepository preguntaRepository;

    //Este metodo permite lisatr todos los registro de la entidad.
    @Transactional
    public List<Pregunta> findAll() throws Exception{
        try {
            return preguntaRepository.findAll();
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Buscar un pregunta mediante su ID.
    @Transactional
    public Pregunta findById(Long id) throws Exception{
        try {
            Optional<Pregunta> entityOptional = preguntaRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public Pregunta save(Pregunta entity) throws Exception{
        try {
            entity = preguntaRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public Pregunta update(Long id, Pregunta entity) throws Exception{
        try {
            Optional<Pregunta> entityOptional = preguntaRepository.findById(id);
            Pregunta pregunta = entityOptional.get();
            pregunta = preguntaRepository.save(entity);
            return  pregunta;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    @Transactional
    public boolean delete(Long id) throws Exception{
        try {
            if(preguntaRepository.existsById(id)){
                preguntaRepository.deleteById(id);
                return  true;
            }else {
                throw  new Exception();
            }
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }
}
