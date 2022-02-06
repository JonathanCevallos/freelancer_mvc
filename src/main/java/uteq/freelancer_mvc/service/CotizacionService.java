package uteq.freelancer_mvc.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uteq.freelancer_mvc.models.Cotizacion;
import uteq.freelancer_mvc.repository.CotizacionRepository;


@Service
public class CotizacionService {
	@Autowired
	private CotizacionRepository cotizacionRepository;
	
	//Este metodo permite listar todos los registros de la entidad.
    @Transactional
    public List<Cotizacion> findAll() throws Exception
    {
        try
        {
            return cotizacionRepository.findAll();
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Buscar una cotización mediante su ID.
    @Transactional
    public Cotizacion findById(int id) throws Exception
    {
        try
        {
            Optional<Cotizacion> entityOptional = cotizacionRepository.findById(id);
            return entityOptional.get();
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public Cotizacion save(Cotizacion entity) throws Exception
    {
        try
        {
            entity = cotizacionRepository.save(entity);
            return entity;
        }
        catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public Cotizacion update(int id, Cotizacion entity) throws Exception
    {
        try
        {
            Optional<Cotizacion> entityOptional = cotizacionRepository.findById(id);
            Cotizacion cotizacion = entityOptional.get();
            cotizacion = cotizacionRepository.save(entity);
            return  cotizacion;
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
            if(cotizacionRepository.existsById(id))
            {
            	cotizacionRepository.deleteById(id);
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