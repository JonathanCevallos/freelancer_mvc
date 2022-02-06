package uteq.freelancer_mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.freelancer_mvc.models.Occupation;
import uteq.freelancer_mvc.repository.OccupationRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OccupationService {
    @Autowired
    private OccupationRepository ocupasionRepository;

    //Este metodo permite listar todos los registro de la entidad.
    @Transactional
    public List<Occupation> findAll() throws Exception
    {
        try
        {
            return ocupasionRepository.findAll();
        }
        catch(Exception ex)
        {
            throw new Exception (ex.getMessage());
        }
    }

    //Este metodo permite: Actualizar una ocupación mediante su ID.
    @Transactional
    public Occupation findById(int id) throws Exception
    {
        try
        {
            Optional<Occupation> entityOptional = ocupasionRepository.findById(id);
            return entityOptional.get();
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public Occupation save(Occupation entity) throws Exception
    {
        try
        {
            entity = ocupasionRepository.save(entity);
            return entity;
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public Occupation update(int id, Occupation entity) throws Exception
    {
        try
        {
            Optional<Occupation> entityOptional = ocupasionRepository.findById(id);
            Occupation occupation = entityOptional.get();
            occupation = ocupasionRepository.save(entity);
            return occupation;
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    @Transactional
    public boolean delete(int id) throws Exception
    {
        try
        {
            if(ocupasionRepository.existsById(id))
            {
                ocupasionRepository.deleteById(id);
                return  true;
            }
            else
            {
                throw  new Exception();
            }
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }
}
