package uteq.freelancer_mvc.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uteq.freelancer_mvc.models.SubCategoria;
import uteq.freelancer_mvc.repository.SubCategoriaRepository;

@Service
public class SubCategoriaService {
	@Autowired
	private SubCategoriaRepository subCategoriaReposiroty;
	
	//Este metodo permite listar todos los registro de la entidad.
    @Transactional
    public List<SubCategoria> findAll() throws Exception
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
    public SubCategoria findById(int id) throws Exception
    {
        try
        {
            Optional<SubCategoria> entityOptional = subCategoriaReposiroty.findById(id);
            return entityOptional.get();
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public SubCategoria save(SubCategoria entity) throws Exception
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
    public SubCategoria update(int id, SubCategoria entity) throws Exception
    {
        try
        {
            Optional<SubCategoria> entityOptional = subCategoriaReposiroty.findById(id);
            SubCategoria subCategoria = entityOptional.get();
            subCategoria = subCategoriaReposiroty.save(entity);
            return  subCategoria;
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