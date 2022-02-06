package uteq.freelancer_mvc.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uteq.freelancer_mvc.models.Idioma;
import uteq.freelancer_mvc.repository.IdiomaRepository;
@Service
public class IdiomaService {
	@Autowired
	private IdiomaRepository idiomaRepository;
	
	//Este metodo permite listar todos los registro de la entidad.
	@Transactional
	public List<Idioma> findAll() throws Exception
	{
		try
		{
			return idiomaRepository.findAll();
		}
		catch(Exception ex)
		{
			throw new Exception (ex.getMessage());
		}
	}
	
	//Este metodo permite: Actualizar un idioma mediante su ID.
    @Transactional
    public Idioma findById(int id) throws Exception
    {
        try
        {
            Optional<Idioma> entityOptional = idiomaRepository.findById(id);
            return entityOptional.get();
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public Idioma save(Idioma entity) throws Exception
    {
        try
        {
            entity = idiomaRepository.save(entity);
            return entity;
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public Idioma update(int id, Idioma entity) throws Exception
    {
        try
        {
            Optional<Idioma> entityOptional = idiomaRepository.findById(id);
            Idioma idioma = entityOptional.get();
            idioma = idiomaRepository.save(entity);
            return  idioma;
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
            if(idiomaRepository.existsById(id))
            {
            	idiomaRepository.deleteById(id);
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
