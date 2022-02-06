package uteq.freelancer_mvc.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.freelancer_mvc.models.People;
import uteq.freelancer_mvc.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	//Este metodo permite listar todos los registro de la entidad.
	@Transactional
	public List<People> findAll() throws Exception
	{
		try
		{
			return userRepository.findAll();
		}
		catch(Exception ex)
		{
			throw new Exception (ex.getMessage());
		}
	}
	
	//Este metodo permite: Actualizar una persona mediante su ID.
    @Transactional
    public People findById(long id) throws Exception
    {
        try
        {
            Optional<People> entityOptional = userRepository.findById(id);
            return entityOptional.get();
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public People save(People entity) throws Exception
    {
        try
        {
            entity = userRepository.save(entity);
            return entity;
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public People update(long id, People entity) throws Exception
    {
        try
        {
            Optional<People> entityOptional = userRepository.findById(id);
            People user = entityOptional.get();
            user = userRepository.save(entity);
            return  user;
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    @Transactional
    public boolean delete(long id) throws Exception
    {
        try
        {
            if(userRepository.existsById(id))
            {
                userRepository.deleteById(id);
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
