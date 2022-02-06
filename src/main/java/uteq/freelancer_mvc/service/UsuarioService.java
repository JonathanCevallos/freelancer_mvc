package uteq.freelancer_mvc.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uteq.freelancer_mvc.models.Usuario;
import uteq.freelancer_mvc.repository.UsuarioRepository;
@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//Este metodo permite listar todos los registro de la entidad.
	@Transactional
	public List<Usuario> findAll() throws Exception
	{
		try
		{
			return usuarioRepository.findAll();
		}
		catch(Exception ex)
		{
			throw new Exception (ex.getMessage());
		}
	}
	
	//Este metodo permite: Actualizar una persona mediante su ID.
    @Transactional
    public Usuario findById(long id) throws Exception
    {
        try
        {
            Optional<Usuario> entityOptional = usuarioRepository.findById(id);
            return entityOptional.get();
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public Usuario save(Usuario entity) throws Exception
    {
        try
        {
            entity = usuarioRepository.save(entity);
            return entity;
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public Usuario update(long id, Usuario entity) throws Exception
    {
        try
        {
            Optional<Usuario> entityOptional = usuarioRepository.findById(id);
            Usuario usuario = entityOptional.get();
            usuario = usuarioRepository.save(entity);
            return  usuario;
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
            if(usuarioRepository.existsById(id))
            {
                usuarioRepository.deleteById(id);
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
