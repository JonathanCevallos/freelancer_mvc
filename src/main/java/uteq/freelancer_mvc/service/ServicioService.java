package uteq.freelancer_mvc.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.freelancer_mvc.models.Servicio;
import uteq.freelancer_mvc.repository.ServicioRepository;

@Service
public class ServicioService {
	@Autowired
	private ServicioRepository servicioRepository;
	
	//Este metodo permite listar todos los registro de la entidad.
	@Transactional
	public List<Servicio> findAll() throws Exception
	{
		try
		{
			return servicioRepository.findAll();
		}
		catch(Exception ex)
		{
			throw new Exception (ex.getMessage());
		}
	}
	
	//Este metodo permite: Actualizar un servicio mediante su ID.
	@Transactional
	public Servicio findById(Long id) throws Exception
	{
	    try
	    {
	        Optional<Servicio> entityOptional = servicioRepository.findById(id);
	        return entityOptional.get();
	    }
	    catch (Exception e)
	    {
	        throw  new Exception(e.getMessage());
	    }
	}

    //Este metodo permite: guardar.
	@Transactional
	public Servicio save(Servicio entity) throws Exception
	{
	    try
	    {
	        entity = servicioRepository.save(entity);
	        return entity;
	    }
	    catch (Exception e)
	    {
	        throw  new Exception(e.getMessage());
	    }
	}

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public Servicio update(Long id, Servicio entity) throws Exception
    {
        try
        {
            Optional<Servicio> entityOptional = servicioRepository.findById(id);
            Servicio servicio = entityOptional.get();
            servicio = servicioRepository.save(entity);
            return  servicio;
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
            if(servicioRepository.existsById(id))
            {
            	servicioRepository.deleteById(id);
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
