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
import uteq.freelancer_mvc.models.Payment;
import uteq.freelancer_mvc.service.PaymentService;

@RestController
@RequestMapping("api/orders")
@CrossOrigin("*")
public class OrderController {
	@Autowired
	private PaymentService paymentService;
	
	//LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Payment>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(paymentService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Payment> finfById(@PathVariable("id")Long id)
    {
        try
        {
            return ResponseEntity.ok().body(paymentService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Payment> create (@RequestBody Payment entity)
    {
        try
        {
            return ResponseEntity.ok().body(paymentService.save(entity));
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
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(paymentService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Payment>update(@PathVariable Long id, @RequestBody Payment entity)
    {
        try
        {
            return ResponseEntity.ok().body(paymentService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
