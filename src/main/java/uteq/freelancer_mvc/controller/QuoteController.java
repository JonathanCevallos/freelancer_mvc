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

import uteq.freelancer_mvc.models.Proforma;
import uteq.freelancer_mvc.service.ProformaService;



@RestController
@RequestMapping("api/quotes")
@CrossOrigin("*")

public class QuoteController {

	@Autowired
	private ProformaService proformaService;
	//LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Proforma>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(proformaService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Proforma> finfById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(proformaService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Proforma> create (@RequestBody Proforma entity)
    {
        try
        {
            return ResponseEntity.ok().body(proformaService.save(entity));
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
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(proformaService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Proforma>update(@PathVariable int id, @RequestBody Proforma entity)
    {
        try
        {
            return ResponseEntity.ok().body(proformaService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
	}