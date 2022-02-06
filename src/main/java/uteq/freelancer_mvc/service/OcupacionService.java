package uteq.freelancer_mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.freelancer_mvc.models.Ocupacion;
import uteq.freelancer_mvc.repository.OcupacionRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OcupacionService {
    @Autowired
    private OcupacionRepository ocupasionRepository;

    //Este metodo permite listar todos los registro de la entidad.
    @Transactional
    public List<Ocupacion> findAll() throws Exception
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
    public Ocupacion findById(int id) throws Exception
    {
        try
        {
            Optional<Ocupacion> entityOptional = ocupasionRepository.findById(id);
            return entityOptional.get();
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public Ocupacion save(Ocupacion entity) throws Exception
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
    public Ocupacion update(int id, Ocupacion entity) throws Exception
    {
        try
        {
            Optional<Ocupacion> entityOptional = ocupasionRepository.findById(id);
            Ocupacion ocupacion = entityOptional.get();
            ocupacion = ocupasionRepository.save(entity);
            return  ocupacion;
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
