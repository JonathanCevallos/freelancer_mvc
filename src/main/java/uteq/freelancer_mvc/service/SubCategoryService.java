package uteq.freelancer_mvc.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uteq.freelancer_mvc.models.SubCategory;
import uteq.freelancer_mvc.repository.SubCategoryRepository;

@Service
public class SubCategoryService {
	@Autowired
	private SubCategoryRepository subCategoriaReposiroty;
	
	//Este metodo permite listar todos los registro de la entidad.
    @Transactional
    public List<SubCategory> findAll() throws Exception
    {
        try
        {
            return subCategoriaReposiroty.findAll();
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Buscar una subcategoría mediante su ID.
    @Transactional
    public SubCategory findById(int id) throws Exception
    {
        try
        {
            Optional<SubCategory> entityOptional = subCategoriaReposiroty.findById(id);
            return entityOptional.get();
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public SubCategory save(SubCategory entity) throws Exception
    {
        try
        {
            entity = subCategoriaReposiroty.save(entity);
            return entity;
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public SubCategory update(int id, SubCategory entity) throws Exception
    {
        try
        {
            Optional<SubCategory> entityOptional = subCategoriaReposiroty.findById(id);
            SubCategory subCategory = entityOptional.get();
            subCategory = subCategoriaReposiroty.save(entity);
            return  subCategory;
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
            if(subCategoriaReposiroty.existsById(id))
            {
            	subCategoriaReposiroty.deleteById(id);
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