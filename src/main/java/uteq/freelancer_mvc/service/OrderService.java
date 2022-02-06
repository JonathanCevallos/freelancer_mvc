package uteq.freelancer_mvc.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.freelancer_mvc.models.Pay;
import uteq.freelancer_mvc.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	//Este metodo permite listar todos los registro de la entidad.
	@Transactional
	public List<Pay> findAll() throws Exception
	{
		try
		{
			return orderRepository.findAll();
		}
		catch(Exception ex)
		{
			throw new Exception (ex.getMessage());
		}
	}
	
	//Este metodo permite: Actualizar una factura mediante su ID.
	@Transactional
	public Pay findById(long id) throws Exception
	{
	    try
	    {
	        Optional<Pay> entityOptional = orderRepository.findById(id);
	        return entityOptional.get();
	    }
	    catch (Exception e)
	    {
	        throw  new Exception(e.getMessage());
	    }
	}

    //Este metodo permite: guardar.
	@Transactional
	public Pay save(Pay entity) throws Exception
	{
	    try
	    {
	        entity = orderRepository.save(entity);
	        return entity;
	    }
	    catch (Exception e)
	    {
	        throw  new Exception(e.getMessage());
	    }
	}

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public Pay update(long id, Pay entity) throws Exception
    {
        try
        {
            Optional<Pay> entityOptional = orderRepository.findById(id);
            Pay pay = entityOptional.get();
            pay = orderRepository.save(entity);
            return pay;
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
            if(orderRepository.existsById(id))
            {
            	orderRepository.deleteById(id);
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
