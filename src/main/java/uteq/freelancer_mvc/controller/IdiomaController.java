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

import uteq.freelancer_mvc.models.Idioma;
import uteq.freelancer_mvc.service.IdiomaService;

@RestController
@RequestMapping("api/idiomas")
@CrossOrigin("*")

public class IdiomaController {
	@Autowired
	private IdiomaService idiomaService;
	
	//LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Idioma>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(idiomaService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Idioma> finfById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(idiomaService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Idioma> create (@RequestBody Idioma entity)
    {
        try
        {
            return ResponseEntity.ok().body(idiomaService.save(entity));
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
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(idiomaService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Idioma>update(@PathVariable int id, @RequestBody Idioma entity)
    {
        try
        {
            return ResponseEntity.ok().body(idiomaService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
