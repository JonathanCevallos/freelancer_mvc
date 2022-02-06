package uteq.freelancer_mvc.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.freelancer_mvc.models.Publication;
import uteq.freelancer_mvc.repository.PublicationRepository;

@Service
public class PublicationService {
	@Autowired
	private PublicationRepository publicationRepository;
	
	//Este metodo permite listar todos los registro de la entidad.
	@Transactional
	public List<Publication> findAll() throws Exception
	{
		try
		{
			return publicationRepository.findAll();
		}
		catch(Exception ex)
		{
			throw new Exception (ex.getMessage());
		}
	}
	
	//Este metodo permite: Actualizar un servicio mediante su ID.
	@Transactional
	public Publication findById(Long id) throws Exception
	{
	    try
	    {
	        Optional<Publication> entityOptional = publicationRepository.findById(id);
	        return entityOptional.get();
	    }
	    catch (Exception e)
	    {
	        throw  new Exception(e.getMessage());
	    }
	}

    //Este metodo permite: guardar.
	@Transactional
	public Publication save(Publication entity) throws Exception
	{
	    try
	    {
	        entity = publicationRepository.save(entity);
	        return entity;
	    }
	    catch (Exception e)
	    {
	        throw  new Exception(e.getMessage());
	    }
	}

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public Publication update(Long id, Publication entity) throws Exception
    {
        try
        {
            Optional<Publication> entityOptional = publicationRepository.findById(id);
            Publication publication = entityOptional.get();
            publication = publicationRepository.save(entity);
            return  publication;
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
            if(publicationRepository.existsById(id))
            {
            	publicationRepository.deleteById(id);
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
