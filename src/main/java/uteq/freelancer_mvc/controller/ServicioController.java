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

import uteq.freelancer_mvc.models.Servicio;
import uteq.freelancer_mvc.service.ServicioService;


@RestController
@RequestMapping("api/servicios")
@CrossOrigin("*")
public class ServicioController {
	@Autowired
	private ServicioService servicioService;
	
	//LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Servicio>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(servicioService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Servicio> finfById(@PathVariable("id")Long id)
    {
        try
        {
            return ResponseEntity.ok().body(servicioService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Servicio> create (@RequestBody Servicio entity)
    {
        try
        {
            return ResponseEntity.ok().body(servicioService.save(entity));
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
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicioService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Servicio>update(@PathVariable Long id, @RequestBody Servicio entity)
    {
        try
        {
            return ResponseEntity.ok().body(servicioService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
