package uteq.freelancer_mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.freelancer_mvc.models.Ability;
import uteq.freelancer_mvc.repository.HabilidadRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class HabilidadService {
    @Autowired
    private HabilidadRepository habilidadRepository;

    //Este metodo permite lisatr todos los registro de la entidad.
    @Transactional
    public List<Ability> findAll() throws Exception{
        try {
            return habilidadRepository.findAll();
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Buscar un habilidad mediante su ID.
    @Transactional
    public Ability findById(int id) throws Exception{
        try {
            Optional<Ability> entityOptional = habilidadRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public Ability save(Ability entity) throws Exception{
        try {
            entity = habilidadRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public Ability update(int id, Ability entity) throws Exception{
        try {
            Optional<Ability> entityOptional = habilidadRepository.findById(id);
            Ability ability = entityOptional.get();
            ability = habilidadRepository.save(entity);
            return ability;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    @Transactional
    public boolean delete(int id) throws Exception{
        try {
            if(habilidadRepository.existsById(id)){
                habilidadRepository.deleteById(id);
                return  true;
            }else {
                throw  new Exception();
            }
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

}
