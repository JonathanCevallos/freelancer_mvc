package uteq.freelancer_mvc.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.freelancer_mvc.models.Order;
import uteq.freelancer_mvc.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	//Este metodo permite listar todos los registro de la entidad.
	@Transactional
	public List<Order> findAll() throws Exception
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
	public Order findById(long id) throws Exception
	{
	    try
	    {
	        Optional<Order> entityOptional = orderRepository.findById(id);
	        return entityOptional.get();
	    }
	    catch (Exception e)
	    {
	        throw  new Exception(e.getMessage());
	    }
	}

    //Este metodo permite: guardar.
	@Transactional
	public Order save(Order entity) throws Exception
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
    public Order update(long id, Order entity) throws Exception
    {
        try
        {
            Optional<Order> entityOptional = orderRepository.findById(id);
            Order order = entityOptional.get();
            order = orderRepository.save(entity);
            return  order;
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
