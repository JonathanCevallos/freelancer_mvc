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

import uteq.freelancer_mvc.models.Quote;
import uteq.freelancer_mvc.service.QuoteService;



@RestController
@RequestMapping("api/quote")
@CrossOrigin("*")

public class QuoteController {

	@Autowired
	private QuoteService quoteService;
	//LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Quote>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(quoteService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Quote> finfById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(quoteService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Quote> create (@RequestBody Quote entity)
    {
        try
        {
            return ResponseEntity.ok().body(quoteService.save(entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ELIMINAR
    @DeleteMapping(value =  "{id}")
    public ResponseEntity<Boolean> delete (@PathVariable int id)
    {
        try
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(quoteService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Quote>update(@PathVariable int id, @RequestBody Quote entity)
    {
        try
        {
            return ResponseEntity.ok().body(quoteService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
	}