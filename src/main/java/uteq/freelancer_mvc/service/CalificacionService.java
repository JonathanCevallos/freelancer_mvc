package uteq.freelancer_mvc.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uteq.freelancer_mvc.models.Calificacion;
import uteq.freelancer_mvc.repository.CalificacionRepository;



@Service
public class CalificacionService {
	@Autowired
	private CalificacionRepository calificacionRepository;
	
	//Este metodo permite listar todos los registro de la entidad.
    @Transactional
    public List<Calificacion> findAll() throws Exception
    {
        try
        {
            return calificacionRepository.findAll();
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Buscar una calificacion mediante su ID.
    @Transactional
    public Calificacion findById(Long id) throws Exception
    {
        try
        {
            Optional<Calificacion> entityOptional = calificacionRepository.findById(id);
            return entityOptional.get();
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public Calificacion save(Calificacion entity) throws Exception
    {
        try
        {
            entity = calificacionRepository.save(entity);
            return entity;
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public Calificacion update(Long id, Calificacion entity) throws Exception
    {
        try
        {
            Optional<Calificacion> entityOptional = calificacionRepository.findById(id);
            Calificacion calificacion = entityOptional.get();
            calificacion = calificacionRepository.save(entity);
            return  calificacion;
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    @Transactional
    public boolean delete(Long id) throws Exception
    {
        try
        {
            if(calificacionRepository.existsById(id))
            {
            	calificacionRepository.deleteById(id);
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
