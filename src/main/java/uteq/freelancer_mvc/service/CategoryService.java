package uteq.freelancer_mvc.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uteq.freelancer_mvc.models.Category;
import uteq.freelancer_mvc.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	//Este metodo permite listar todos los registro de la entidad.
    @Transactional
    public List<Category> findAll() throws Exception
    {
        try
        {
            return categoryRepository.findAll();
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Buscar una categoría mediante su ID.
    @Transactional
    public Category findById(int id) throws Exception
    {
        try
        {
            Optional<Category> entityOptional = categoryRepository.findById(id);
            return entityOptional.get();
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public Category save(Category entity) throws Exception
    {
        try
        {
            entity = categoryRepository.save(entity);
            return entity;
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public Category update(int id, Category entity) throws Exception
    {
        try
        {
            Optional<Category> entityOptional = categoryRepository.findById(id);
            Category category = entityOptional.get();
            category = categoryRepository.save(entity);
            return  category;
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
            if(categoryRepository.existsById(id))
            {
            	categoryRepository.deleteById(id);
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
