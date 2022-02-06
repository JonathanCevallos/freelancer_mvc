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

import uteq.freelancer_mvc.models.Pais;
import uteq.freelancer_mvc.service.PaisService;

@RestController
@RequestMapping("api/paises")
@CrossOrigin("*")
public class PaisController {
	@Autowired
	private PaisService paisService;
	
	//LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Pais>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(paisService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Pais> finfById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(paisService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Pais> create (@RequestBody Pais entity)
    {
        try
        {
            return ResponseEntity.ok().body(paisService.save(entity));
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
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(paisService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Pais>update(@PathVariable int id, @RequestBody Pais entity)
    {
        try
        {
            return ResponseEntity.ok().body(paisService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
