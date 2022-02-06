package uteq.freelancer_mvc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uteq.freelancer_mvc.models.Pay;
import uteq.freelancer_mvc.service.OrderService;

@RestController
@RequestMapping("api/order")
@CrossOrigin("*")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	//LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Pay>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(orderService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Pay> finfById(@PathVariable("id")Long id)
    {
        try
        {
            return ResponseEntity.ok().body(orderService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Pay> create (@RequestBody Pay entity)
    {
        try
        {
            return ResponseEntity.ok().body(orderService.save(entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ELIMINAR
    @DeleteMapping(value =  "{id}")
    public ResponseEntity<Boolean> delete (@PathVariable Long id)
    {
        try
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(orderService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Pay>update(@PathVariable Long id, @RequestBody Pay entity)
    {
        try
        {
            return ResponseEntity.ok().body(orderService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
