package uteq.freelancer_mvc.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uteq.freelancer_mvc.models.Pais;
import uteq.freelancer_mvc.repository.PaisRepository;
@Service
public class PaisService {
	@Autowired
	private PaisRepository paisRepository;
	
	//Este metodo permite listar todos los registro de la entidad.
	@Transactional
	public List<Pais> findAll() throws Exception
	{
		try
		{
			return paisRepository.findAll();
		}
		catch(Exception ex)
		{
			throw new Exception (ex.getMessage());
		}
	}
	
	//Este metodo permite: Actualizar un país mediante su ID.
	@Transactional
	public Pais findById(int id) throws Exception
	{
	    try
	    {
	        Optional<Pais> entityOptional = paisRepository.findById(id);
	        return entityOptional.get();
	    }
	    catch (Exception e)
	    {
	        throw  new Exception(e.getMessage());
	    }
	}

    //Este metodo permite: guardar
	@Transactional
	public Pais save(Pais entity) throws Exception
	{
	    try
	    {
	        entity = paisRepository.save(entity);
	        return entity;
	    }
	    catch (Exception e)
	    {
	        throw  new Exception(e.getMessage());
	    }
	}

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public Pais update(int id, Pais entity) throws Exception
    {
        try
        {
            Optional<Pais> entityOptional = paisRepository.findById(id);
            Pais pais = entityOptional.get();
            pais = paisRepository.save(entity);
            return  pais;
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
            if(paisRepository.existsById(id))
            {
            	paisRepository.deleteById(id);
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
