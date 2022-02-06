package uteq.freelancer_mvc.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uteq.freelancer_mvc.models.Categoria;
import uteq.freelancer_mvc.repository.CategoriaRepository;

@Service
public class CategoriaController {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	//Este metodo permite listar todos los registro de la entidad.
    @Transactional
    public List<Categoria> findAll() throws Exception
    {
        try
        {
            return categoriaRepository.findAll();
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Buscar una categoría mediante su ID.
    @Transactional
    public Categoria findById(int id) throws Exception
    {
        try
        {
            Optional<Categoria> entityOptional = categoriaRepository.findById(id);
            return entityOptional.get();
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public Categoria save(Categoria entity) throws Exception
    {
        try
        {
            entity = categoriaRepository.save(entity);
            return entity;
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public Categoria update(int id, Categoria entity) throws Exception
    {
        try
        {
            Optional<Categoria> entityOptional = categoriaRepository.findById(id);
            Categoria categoria = entityOptional.get();
            categoria = categoriaRepository.save(entity);
            return  categoria;
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
            if(categoriaRepository.existsById(id))
            {
            	categoriaRepository.deleteById(id);
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
